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

import holoedit.data.HoloTrack;
import holoedit.data.HoloTraj;
import holoedit.functions.Algorithm;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import holoedit.util.Ut;

public class TimeReverse extends Algorithm
{
	public TimeReverse(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ATOB,"timereverse","Time Reverse","Reverses the current time selection of the Input track in time and pastes it in the Output track.\n(Continue pastes it at the end, Replace replaces it)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		setCategory(CAT_TRANS_TIME);
	}

	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		gp.Copy(tkNthFrom);
		int dateFin;
		dateFin = gp.copyTrack.getLastDate();
		HoloTrack newPiste = new HoloTrack();
		for (int k = gp.copyTrack.trajs.size() - 1; k >= 0; k--)
		{
			HoloTraj ht = gp.copyTrack.trajs.get(k);
			int date = ht.getLastDate();
			newPiste.addTraj(ht.reverse(), dateFin - date);
			inc(ht.size());
		}
		newPiste.update();
		gp.copyTrack = newPiste.dupliquer();
		if (replace)
			gp.ReplaceWithoutStore(tkNthTo);
		else gp.PasteWithoutStore(tkNthTo);
		gp.getTrack(tkNthTo).update();
		int endReverse = gp.copyTrack.getLastDate() + dateBegin + (replace ? 0 : dateFin);
		gp.update(tkNthTo, dateEnd >= endReverse ? dateEnd : endReverse);
		gp.copyTrack = tmpTrack.dupliquer();
	}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
	
}
