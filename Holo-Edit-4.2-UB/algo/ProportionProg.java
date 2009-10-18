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

public class ProportionProg extends Algorithm
{
	public ProportionProg(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ATOB,"proportion_prog","Proportion Progressive","Performs a progressive homothety on the current time selection of the Input track with different initial and final ratios on each axis and pastes it in the Output track.");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Initial proportion for X (%)", 20f));
		addField(new Field("Final proportion for X (%)", 80f));
		addField(new Field("Initial proportion for Y (%)", 20f));
		addField(new Field("Final proportion for Y (%)", 80f));
		addField(new Field("Initial proportion for Z (%)", 20f));
		addField(new Field("Final proportion for Z (%)", 80f));
		setCategory(CAT_TRANS_SPAT);
	}
	
	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		HoloPoint tempPt;
		gp.Copy(tkNthFrom);
		float Xi = (Float) results[3] / 100;
		float Xf = (Float) results[4] / 100;
		float Yi = (Float) results[5] / 100;
		float Yf = (Float) results[6] / 100;
		float Zi = (Float) results[7] / 100;
		float Zf = (Float) results[8] / 100;
		int date = gp.copyTrack.getLastDate();
		for (int i = 0; i < gp.copyTrack.size(); i++)
		{
			tempPt = gp.copyTrack.elementAt(i);
			float step = ((float) tempPt.date / date);
			tempPt.x = HoloPoint.limit2D(tempPt.x * (Xi + (Xf - Xi) * step));
			tempPt.y = HoloPoint.limit2D(tempPt.y * (Yi + (Yf - Yi) * step));
			tempPt.z = HoloPoint.limitZ(tempPt.z * (Zi + (Zf - Zi) * step));
			inc();
		}
		gp.ReplaceWithoutStore(tkNthTo);
		gp.copyTrack = tmpTrack.dupliquer();
		gp.update(tkNthTo, -1);
	}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
