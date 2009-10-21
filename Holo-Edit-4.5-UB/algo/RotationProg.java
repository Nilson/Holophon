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
import holoedit.functions.Algorithm;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import holoedit.util.Ut;

public class RotationProg extends Algorithm
{
	public RotationProg(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ATOB,"rotation_prog","Rotation Progressive","Rotates the current time selection of the Input track by an evolving angle (in degrees) and pastes it in the Output track.");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Initial angle (" + Ut.numCar + "d)", Param.TYPE_DOUBLE, 0., -36000, 36000));
		addField(new Field("Final angle (" + Ut.numCar + "d)", Param.TYPE_DOUBLE, 360., -36000, 36000));
		setCategory(CAT_TRANS_SPAT);
	}

	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		gp.Copy(tkNthFrom);
		// --- parametres fournis par l'utilisateur :
		double aI = (Double) results[3] * Math.PI / 180;
		double aF = (Double) results[4] * Math.PI / 180;
		int date = gp.copyTrack.getLastDate();
		for (int i = 0; i < gp.copyTrack.size(); i++)
		{
			HoloPoint tempPt = gp.copyTrack.elementAt(i);
			double x = tempPt.x;
			double y = tempPt.y;
			double step = ((double) tempPt.date / date);
			double teta = calcAngle(x, y) + (aI + (aF - aI) * step);
			double d = calcDistance(x, y);
			tempPt.x = HoloPoint.limit2D((float) polX(teta, d));
			tempPt.y = HoloPoint.limit2D((float) polY(teta, d));
			inc();
		}
		gp.ReplaceWithoutStore(tkNthTo);
		gp.copyTrack = tmpTrack.dupliquer();
		gp.update(tkNthTo, -1);
	}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
