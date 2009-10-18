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
import holoedit.data.HoloTraj;
import holoedit.functions.Algorithm;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import holoedit.util.Ut;

public class Brownian extends Algorithm
{
	float minX, maxX, dbX, minY, maxY, dbY, minZ, maxZ, dbZ;
	
	public Brownian(GestionPistes gp)
	{
		super(gp,TYPE_GEN,"brownian","Brownian","Generates a brownian trajectory.\nGiven a first point, each next point is calculated following a random walk, each step size depending on the variance factor.\n(Continue pastes it at the end, Replace replaces it)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Duration (sec)", Param.TYPE_DOUBLE, 20., 0.01, Double.MAX_VALUE));
		addField(new Field("Time resolution (sec)", Param.TYPE_DOUBLE, 0.1, 0.01, Double.MAX_VALUE));
		addField(new Field("Brownien factor (%)", Param.TYPE_FLOAT, 10f, 0.01, Double.MAX_VALUE));
		addField(new Field("Enable Z", false));
		addField(new Field("Minimum X", Param.TYPE_FLOAT, -100f, HoloPoint.LOWLIM2D, HoloPoint.UPLIM2D));
		addField(new Field("Maximum X", Param.TYPE_FLOAT, 100f, HoloPoint.LOWLIM2D, HoloPoint.UPLIM2D));
		addField(new Field("Minimum Y", Param.TYPE_FLOAT, -100f, HoloPoint.LOWLIM2D, HoloPoint.UPLIM2D));
		addField(new Field("Maximum Y", Param.TYPE_FLOAT, 100f, HoloPoint.LOWLIM2D, HoloPoint.UPLIM2D));
		addField(new Field("Minimum Z", Param.TYPE_FLOAT, 0f, HoloPoint.LOWLIMZ, HoloPoint.UPLIMZ));
		addField(new Field("Maximum Z", Param.TYPE_FLOAT, 100f, HoloPoint.LOWLIMZ, HoloPoint.UPLIMZ));
		setCategory(CAT_GEN);
	}
	
	protected void treatOneTrack(int tkNth)
	{
		int curTime;
		HoloTraj ht = new HoloTraj();
		HoloPoint curPt = null;
		if (!replace)
			curPt = gp.getTrack(tkNth).lastElement();
		else
			curPt = gp.getTrack(tkNth).elementAt(gp.getTrack(tkNth).previousPoint2(dateBegin));
		if (curPt == null)
			curPt = new HoloPoint();
		// --- initialisation -----
		int dur = (int)((Double)results[2] * 100); // 1/100e sec
		int durPoint =(int)((Double)results[3] * 100); // 1/100e sec */
		float brown = (Float) results[4] / 100;
		boolean enableZ = (Boolean)results[5];
		minX = (Float) results[6];
		maxX = (Float) results[7];
		dbX = (maxX - minX) * brown;
		minY = (Float) results[8];
		maxY = (Float) results[9];
		dbY = (maxY - minY) * brown;
		minZ = (Float) results[10];
		maxZ = (Float) results[11];
		dbZ = (maxZ - minZ) * brown;
		for (curTime = 0; curTime < dur; curTime = curTime + durPoint)
		{
			curPt = brownianPoint(curPt);
			curPt.date = curTime + dateBegin;
			curPt.x = HoloPoint.limit2D(curPt.x);
			curPt.y = HoloPoint.limit2D(curPt.y);
			curPt.z = enableZ ? HoloPoint.limitZ(curPt.z) : 0;
			ht.addElement(curPt);
			inc();
		}
		finalizeTraj(tkNth, ht, dur);
	}

	private HoloPoint brownianPoint(HoloPoint originPt)
	{
		HoloPoint point = new HoloPoint();
		point.x = (float) (originPt.x + ((Math.random() * 2) - 1) * dbX);
		point.y = (float) (originPt.y + ((Math.random() * 2) - 1) * dbY);
		point.z = (float) (originPt.z + ((Math.random() * 2) - 1) * dbZ);
		
		if(point.x <= minX)
			point.x = point.x + 2*(minX - point.x);
		
		if(point.y <= minY)
			point.y = point.y + 2*(minY - point.y);
		
		if(point.z <= minZ)
			point.z = point.z + 2*(minZ - point.z);
		
		if(point.x >= maxX)
			point.x = point.x + 2*(maxX - point.x);
		
		if(point.y >= maxY)
			point.y = point.y + 2*(maxY - point.y);
		
		if(point.z >= maxZ)
			point.z = point.z + 2*(maxZ - point.z);
		
		return point;
	}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
