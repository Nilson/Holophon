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

public class TimeStretch extends Algorithm
{
	public TimeStretch(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ATOB,"timestrech","Time Stretch","Stretches the current time selection of the Input track in time and pastes it in the Output track.\n(50% representing half the time of the selected portion)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Factor [0-oo]%", Param.TYPE_DOUBLE, 200., 0, Double.MAX_VALUE));
		setCategory(CAT_TRANS_TIME);
	}

	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		HoloPoint hpi;
		gp.Copy(tkNthFrom);
		// --- parametres fournis par l'utilisateur :
		double scaler = Math.abs((Double)results[3] / 100.);
		if (!gp.copyTrack.isEmpty())
		{
			for (int i = 0; i < gp.copyTrack.size(); i++)
			{
				hpi = gp.copyTrack.elementAt(i);
				hpi.date = (int) (hpi.date * scaler);
				inc();
			}
		}
		gp.ReplaceWithoutStore(tkNthTo);
		int endStretch = gp.copyTrack.getLastDate() + dateBegin;
		gp.update(tkNthTo, dateEnd >= endStretch ? dateEnd : endStretch);
		gp.copyTrack = tmpTrack.dupliquer();
	}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
