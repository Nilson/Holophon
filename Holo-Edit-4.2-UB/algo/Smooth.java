/**
 *  -----------------------------------------------------------------------------
 *  
 *  Holo-Edit, spatial sound trajectories editor, part of Holophon
 *  Copyright (C) 2006 GMEM
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA 
 *  
 *  -----------------------------------------------------------------------------
 */
package algo;

import holoedit.data.HoloPoint;
import holoedit.data.HoloPointVector;
import holoedit.data.HoloTrack;
import holoedit.data.HoloTraj;
import holoedit.functions.Algorithm;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import holoedit.util.Ut;

// ALGO SMOOTH
/* 
 * Perform smoothing by "convolving with a quasi gaussian window. 
 * You can tune the length of the window ( eg. duration of the window )
 */
public class Smooth extends Algorithm
{
	public Smooth(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ATOB,"smooth","Smooth","Smoothes the current time selection of the Input track and pastes it in the Output track.\nThe trajectory is Filtered with a time window with <smoothness> seconds length");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Smoothness (sec.)", Param.TYPE_DOUBLE, 1., 0.05, 10.));
		addField(new Field("Points per sec.", Param.TYPE_DOUBLE, 20., 1., 100.));
		setCategory(CAT_TRANS_SPAT);
	}

	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		//HoloTrack inTrack = gp.getTrack(tkNthFrom);
		//HoloTraj outTraj = new HoloTraj();
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		gp.Copy(tkNthFrom);
		
		HoloPoint curPoint = new HoloPoint();
		HoloPoint ctrlPoint ;
		
		// --- parametres fournis par l'utilisateur :
		double smoothness = (Double)results[3];
		double winLength = smoothness * 100;
		double pts_ps = (Double)results[4];
		double step = 100/pts_ps;
		//boolean only_ed = (Boolean)results[5];
		
		// -- parametre algo interne
		int firstIndex=0, lastIndex=0, maxIndex=0, minIndex=0;
		double traj_length;
		int traj_size;
		int nb_pts_out ;//= Math.floor(traj_length/step); 
		int curTime ;//= dateBegin;
		double ctrlDate;
		
		double coef;
		double coefSum =0.;
		int j;
		
		double densPtBeg,densPtEnd ;
		int deltaPtBeg,deltaPtEnd ;
		int padBegin,padEnd;

		
		//System.out.println(inTrack.toString());
		System.out.println(maxIndex);
		
		
		
		for (HoloTraj ht : gp.copyTrack.trajs)
		{
			HoloPointVector ctrlPts = new HoloPointVector(ht.points);
			
			traj_length = ht.getDuration();
			traj_size = ht.size();
			nb_pts_out = (int) Math.floor(traj_length/step);
			curTime = ht.getFirstDate();
			
			//System.out.println(traj_length + " "+ ht.toString());
			
			HoloPointVector finalPts = new HoloPointVector(nb_pts_out + 1, 5);
			
//			 ajout "padding" de pts au debut et ˆ la fin
			densPtBeg = winLength /(deltaPtBeg =(ctrlPts.get(1).date - ctrlPts.get(0).date));
			densPtEnd = winLength /(deltaPtEnd =(ctrlPts.get(traj_size-1).date -ctrlPts.get(traj_size-2).date));
			
			padBegin = (int) densPtBeg;
			padEnd = (int) densPtEnd;
			
			float dx,dy,dz;
			HoloPoint tmpPoint;
			HoloPoint refPoint;
			int date_begin = ctrlPts.get(0).date;
			int date_end = ctrlPts.get(ctrlPts.size()-1).date;
			// Padding ( symetrie tu trajet en fonction du premier/dernier point )
			
			// pad debut
			dx = ctrlPts.get(0).getX() ;
			dy = ctrlPts.get(0).getY() ;
			dz = ctrlPts.get(0).getZ() ;
			for (int i=1; i<=padBegin;i++)
			{
				refPoint = ctrlPts.get(Math.min(2*i-1,ctrlPts.size()-1));
				tmpPoint = ctrlPts.get(0).dupliquer();
				tmpPoint.x = 2 * dx - refPoint.x;
				tmpPoint.y = 2 * dy - refPoint.y;
				tmpPoint.z = 2 * dz - refPoint.z;
				tmpPoint.date = 2 * date_begin - refPoint.date;
				ctrlPts.insertElementAt(tmpPoint.dupliquer(), 0);
			}
			
//			 pad fin
			dx = ctrlPts.get(ctrlPts.size()-1).getX();
			dy = ctrlPts.get(ctrlPts.size()-1).getY();
			dz = ctrlPts.get(ctrlPts.size()-1).getZ();
			for (int i=1; i<=padEnd;i++)
			{
				refPoint = ctrlPts.get(Math.max(ctrlPts.size() -2*i,0));
				tmpPoint = ctrlPts.get(ctrlPts.size()-1).dupliquer();
				tmpPoint.x = 2 * dx - refPoint.x;
				tmpPoint.y = 2 * dy - refPoint.y;
				tmpPoint.z = 2 * dz - refPoint.z;
				tmpPoint.date = 2 * date_end - refPoint.date;
				ctrlPts.insertElementAt(tmpPoint.dupliquer(),ctrlPts.size());
			}
			
			minIndex = 0;
			maxIndex = ctrlPts.size()-1;
			firstIndex = minIndex;
			lastIndex = minIndex;
			
			
			for(int i=0; i<nb_pts_out; i++)
			{
				// remise a zeros des param de boucle
				curPoint.x = 0;
				curPoint.y = 0;
				curPoint.z = 0;
				coefSum = 0;

				//si 1er ou dernier element ->  copie
				if(i==0)
					finalPts.addElement(ctrlPts.get(padBegin).dupliquer());
				else if(i==(nb_pts_out-1))
					finalPts.addElement(ctrlPts.get(ctrlPts.size()-padEnd-1).dupliquer());
				else
				{
					//sinon smooth interpol
					try{
					while(ctrlPts.get(firstIndex).date < curTime - winLength && ctrlPts.get(firstIndex+1).date < curTime )
						firstIndex ++;
					while(lastIndex < maxIndex && ctrlPts.get(lastIndex).date < curTime + winLength)
					{
						lastIndex++;
						inc();
					}
					
					// si trop peu de pts de controles -> interpolation
					if ( lastIndex - firstIndex <= 2)
					{
						int fi = (ctrlPts.get(firstIndex+1).date < curTime)? firstIndex+1 : firstIndex;
						int li = (ctrlPts.get(lastIndex-1).date > curTime)? lastIndex-1 : lastIndex;
						HoloPoint p1 = ctrlPts.get(fi);
						HoloPoint p2 = ctrlPts.get(li);
						tmpPoint = HoloPoint.interpol(p1, p2, curTime);
						if(tmpPoint !=null)
							curPoint = tmpPoint;
						else
						{
							System.out.println("smooth interpol no points @ "+curTime);
							tmpPoint = p2.dupliquer();
						}
					}
					else{// traitement fenetre
						for(j=firstIndex; j<lastIndex; j++)
						{
							ctrlDate = 3*(curTime - (ctrlPoint = ctrlPts.get(j)).date)/winLength;
							coef = Math.exp(-ctrlDate*ctrlDate);
							
							coefSum += coef;
							curPoint.x += coef * ctrlPoint.x;
							curPoint.y += coef * ctrlPoint.y;
							curPoint.z += coef * ctrlPoint.z;

						}

						curPoint.diviserCoord((float) coefSum);
					}
					curPoint.date = curTime;
					finalPts.addElement(curPoint.dupliquer());
				}
				catch ( NullPointerException e)
				{
					System.out.println("Null pointer in Smooth algo");
				}
				}
				curTime += step;


			}
			
			ht.points = (HoloPointVector) finalPts.clone();
		}
		//System.out.println(gp.copyTrack.toString());
		gp.copyTrack.update();
		gp.ReplaceWithoutStore(tkNthTo);
		gp.getTrack(tkNthTo).update();
		gp.update(tkNthTo, -1);
		gp.copyTrack = tmpTrack.dupliquer();
	}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
