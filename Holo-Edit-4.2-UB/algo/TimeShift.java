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

public class TimeShift extends Algorithm
{
	public TimeShift(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ATOB,"timeshift","Time Shift","Shifts the current time selection of the Input track in time and pastes it in the Output track.");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Shift (mn)", 0));
		addField(new Field("Shift (sec)", 0));
		addField(new Field("Shift (1/100e)", 0));
		setCategory(CAT_TRANS_TIME);
	}
	
	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		gp.Copy(tkNthFrom);
		// --- parametres fournis par l'utilisateur :
		int deltaTime = (Integer) results[5] + (Integer) results[4] * 100 + (Integer) results[3] * 6000;
		for (int i = 0; i < gp.copyTrack.size(); i++)
		{
			HoloPoint hp = gp.copyTrack.elementAt(i);
			hp.date += deltaTime;
			inc();
		}
		gp.ReplaceWithoutStore(tkNthTo);
		int endShift = gp.copyTrack.getLastDate() + dateBegin;
		gp.update(tkNthTo, dateEnd >= endShift ? dateEnd : endShift);
		gp.copyTrack = tmpTrack.dupliquer();
	}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
