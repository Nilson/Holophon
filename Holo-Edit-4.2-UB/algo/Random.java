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
import holoedit.data.HoloSpeaker;
import holoedit.data.HoloTraj;
import holoedit.functions.Algorithm;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import holoedit.util.Ut;

public class Random extends Algorithm
{
	public Random(GestionPistes gp)
	{
		super(gp,TYPE_GEN,"random","Random","Generates a random trajectory jumping from one speaker to another.\n(Continue pastes it at the end, Replace replaces it)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Duration (sec)", Param.TYPE_DOUBLE, 20., 0.01, Double.MAX_VALUE));
		addField(new Field("Time resolution (sec)", Param.TYPE_DOUBLE, 0.1, 0.01, Double.MAX_VALUE));
		addField(new Field("Initial distance", 40.));
		addField(new Field("Final distance", 20.));
		addField(new Field("Enable Z", false));
		setCategory(CAT_GEN);
	}

	protected void treatOneTrack(int tkNth)
	{
		HoloTraj ht = new HoloTraj();
		HoloPoint curPt = new HoloPoint();
		double dist, scaler, dir;
		int alea;
		int dur = (int)((Double)results[2] * 100); // 1/100e sec
		int durPoint = (int)((Double)results[3] * 100); // 1/100e sec
		double distI = (Double)results[4];
		double distF = (Double)results[5];
		boolean enableZ = (Boolean)results[6];
		for(HoloSpeaker sp:gp.speakers)
			sp.recalcDist();
		for (int curTime = 0; curTime < dur; curTime += durPoint)
		{
			scaler = (double)curTime / dur;
			alea = (int) (gp.speakers.size() * Math.random());
			dist = Ut.interpol(distI, distF, scaler);
			dir = gp.speakers.get(alea).dir;
			curPt = aleaPoint(dir, dist);
			curPt.date = curTime + dateBegin;
			curPt.x = HoloPoint.limit2D(curPt.x);
			curPt.y = HoloPoint.limit2D(curPt.y);
			curPt.z = enableZ ? (float) (gp.speakers.get(alea).Z * Math.random()) : 0;
			ht.addElement(curPt);
			inc();
		}
		finalizeTraj(tkNth, ht, dur);
	}

	private HoloPoint aleaPoint(double angle, double dist)
	{
		HoloPoint point = new HoloPoint();
		point.x = (float) polX(angle, dist);
		point.y = (float) polY(angle, dist);
		return point;
	}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
