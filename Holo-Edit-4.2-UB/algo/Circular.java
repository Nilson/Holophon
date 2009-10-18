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

public class Circular extends Algorithm
{
	public Circular(GestionPistes gp)
	{
		super(gp, TYPE_GEN, "circular", "Circular", "Generates a circular trajectory with different initial and final radius on the x and y axis.\n(Continue pastes it at the end, Replace replaces it)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Duration (sec)", Param.TYPE_DOUBLE, 20., 0.01, Double.MAX_VALUE));
		addField(new Field("Time resolution (sec)", Param.TYPE_DOUBLE, 0.1, 0.01, Double.MAX_VALUE));
		addField(new Field("Initial radius on X", 30.));
		addField(new Field("Final radius on X", 20.));
		addField(new Field("Initial radius on Y", 30.));
		addField(new Field("Final radius on Y", 20.));
		addField(new Field("Enable Z", false));
		addField(new Field("Initial elevation on Z", Param.TYPE_DOUBLE, 0., HoloPoint.LOWLIMZ, HoloPoint.UPLIMZ));
		addField(new Field("Final elevation on Z", Param.TYPE_DOUBLE, 0., HoloPoint.LOWLIMZ, HoloPoint.UPLIMZ));
		addField(new Field("Circles per second", Param.TYPE_DOUBLE, 0.5, 0.01, Double.MAX_VALUE));
		addField(new Field("Initial angle (" + Ut.numCar + "d)", Param.TYPE_DOUBLE, 0., -360, 360, 360));
		addField(new Field("Direction", Param.TYPE_COMBO, 0, "clock"));
		setCategory(Algorithm.CAT_GEN);
	}

	protected void treatOneTrack(int tkNth)
	{
		HoloTraj ht = new HoloTraj();
		HoloPoint curPt = new HoloPoint();
		double dur = (Double)results[2] * 100; // 1/100e sec
		double durPoint = (Double)results[3] * 100; // 1/100e sec
		double angle, angleElt;
		// --- parametres fournis par l'utilisateur :
		double Xi = (Double)results[4];
		double Xf = (Double)results[5];
		double Yi = (Double)results[6];
		double Yf = (Double)results[7];
		boolean enableZ = (Boolean)results[8];
		double Zi = (Double)results[9];
		double Zf = (Double)results[10];
		double tourParSec = (Double)results[11];
		double angleInit = (Double)results[12];
		int sens = (Integer) results[13] > 0 ? 1 : -1;
		// -----------------------------------------------------
		// -----------------------------------------------------
		angleElt = (sens * tourParSec * durPoint * 2. * Math.PI / 100.);
		angle = angleInit = (angleInit * Math.PI / 180.);
		double curTime = 0;
		int nbPoints = (int) (dur / durPoint);
		for (int n = 0; n <= nbPoints; n++)
		{
			curTime = n * durPoint;
			curPt = new HoloPoint();
			curPt.date = (int) curTime + dateBegin;
			angle = angleInit + (n * angleElt);
			curPt.x = HoloPoint.limit2D((float) polX(angle, Ut.interpol(Xi, Xf, (curTime / dur))));
			curPt.y = HoloPoint.limit2D((float) polY(angle, Ut.interpol(Yi, Yf, (curTime / dur))));
			curPt.z = enableZ ? HoloPoint.limitZ((float) Ut.interpol(Zi, Zf, (curTime / dur))) : 0;
			ht.addElement(curPt);
			inc();
		}
		finalizeTraj(tkNth, ht, (int) dur);
	}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo){}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo){}	
}
