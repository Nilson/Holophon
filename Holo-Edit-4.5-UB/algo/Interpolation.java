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
import holoedit.data.HoloTrack;
import holoedit.data.HoloTraj;
import holoedit.functions.Algorithm;
import holoedit.functions.Algors;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import holoedit.util.Ut;

public class Interpolation extends Algorithm
{
	public Interpolation(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ABTOC,"interpolation","Interpolation","Interpolates between two tracks A and B with initial and final factors on each axis and pastes it in the Ouput track.\n(0% representing A and 100% representing B)");
		addField(new Field("A -> input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("-> B input track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 3));
		addField(new Field("Initial scaling fact. on X (%)", 100.));
		addField(new Field("Final scaling fact. on X (%)", 0.));
		addField(new Field("Initial scaling fact. on Y (%)", 100.));
		addField(new Field("Final scaling fact. on Y (%)", 0.));
		addField(new Field("Initial scaling fact. on Z (%)", 100.));
		addField(new Field("Final scaling fact. on Z (%)", 0.));
		setCategory(CAT_TRANS_SPAT);
	}
	
	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo)
	{
		Algors a= new Algors();
		a.dateBegin = dateBegin;
		a.dateEnd = dateEnd;
		HoloTrack tmpTrackA = a.Copy(gp.getTrack(tkNthFromA), false);
		HoloTrack tmpTrackB = a.Copy(gp.getTrack(tkNthFromB), false);
		if (!tmpTrackA.isEmpty() && !tmpTrackB.isEmpty())
		{
			int i;
			double date, date1, date2;
			double scX, scY, scZ, scXi, scYi, scZi, scXf, scYf, scZf;
			HoloTraj ht = new HoloTraj();
			HoloPoint tempPtA = new HoloPoint();
			HoloPoint prevPtB = new HoloPoint();
			HoloPoint nextPtB = new HoloPoint();
			// --- parametres fournis par l'utilisateur :
			// --- initialisation -----
			scXi = (Double)results[3] / 100;
			scXf = (Double)results[4] / 100;
			scYi = (Double)results[5] / 100;
			scYf = (Double)results[6] / 100;
			scZi = (Double)results[7] / 100;
			scZf = (Double)results[8] / 100;
			tempPtA = tmpTrackA.firstElement();
			date1 = tempPtA.date;
			tempPtA = tmpTrackB.lastElement();
			date2 = tempPtA.date;
			for (i = 0; i < tmpTrackA.size(); i++)
			{
				tempPtA = tmpTrackA.elementAt(i);
				date = tempPtA.date;
				prevPtB = calcprevpt(tempPtA, tmpTrackB);
				nextPtB = calcnextpt(tempPtA, tmpTrackB);
				scX = Ut.interpol(scXi, scXf, (date - date1) / (date2 - date1));
				scY = Ut.interpol(scYi, scYf, (date - date1) / (date2 - date1));
				scZ = Ut.interpol(scZi, scZf, (date - date1) / (date2 - date1));
				ht.addElement(intpolpt(tempPtA, prevPtB, nextPtB, scX, scY, scZ));
				inc();
			}
			replace = true;
			finalizeTraj(tkNthTo, ht, dateEnd - dateBegin);
		}
	}
	
	public HoloPoint calcprevpt(HoloPoint pt, HoloTrack pointsB)
	{
		HoloPoint ptResult = pointsB.firstElement();
		HoloPoint pt2 = ptResult;
		if (ptResult.date > pt.date)
		{
			ptResult = pt;
		} else {
			for (int n = 0; n < pointsB.size() && pt2.date < pt.date; n++)
			{
				pt2 = pointsB.elementAt(n);
				ptResult = pt2;
			}
		}
		return ptResult;
	}

	public HoloPoint calcnextpt(HoloPoint pt, HoloTrack pointsB)
	{
		HoloPoint ptResult = pointsB.firstElement();
		HoloPoint pt2 = ptResult;
		if (ptResult.date > pt.date)
		{
		} else {
			for (int n = 1; n < pointsB.size() && pt2.date <= pt.date; n++)
			{
				pt2 = pointsB.elementAt(n);
				ptResult = pt2;
			}
		}
		return ptResult;
	}

	public HoloPoint intpolpt(HoloPoint pt, HoloPoint prevPt, HoloPoint nextPt, double scX, double scY, double scZ)
	{
		double Xref, Yref, Zref;
		double Xresult = pt.x;
		double Yresult = pt.y;
		double Zresult = pt.z;
		double date = pt.date;
		double date1 = prevPt.date;
		double date2 = nextPt.date;
		if (date1 != date2)
		{
			Xref = Ut.interpol(prevPt.x, nextPt.x, (date - date1) / (date2 - date1));
			Yref = Ut.interpol(prevPt.y, nextPt.y, (date - date1) / (date2 - date1));
			Zref = Ut.interpol(prevPt.z, nextPt.z, (date - date1) / (date2 - date1));
			Xresult = Ut.interpol(Xresult, Xref, scX);
			Yresult = Ut.interpol(Yresult, Yref, scY);
			Zresult = Ut.interpol(Zresult, Zref, scZ);
		}
		else
		{
			Xref = prevPt.x;
			Yref = prevPt.y;
			Zref = prevPt.z;
			Xresult = Ut.interpol(Xresult, Xref, scX);
			Yresult = Ut.interpol(Yresult, Yref, scY);
			Zresult = Ut.interpol(Zresult, Zref, scZ);
		}
		return new HoloPoint((float) Xresult, (float) Yresult, (float) Zresult, (int) date, pt.isEditable());
	}

}
