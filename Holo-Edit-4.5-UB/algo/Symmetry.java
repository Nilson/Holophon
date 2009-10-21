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

public class Symmetry extends Algorithm
{
	public Symmetry(GestionPistes gp)
	{
		super(gp,Algorithm.TYPE_TRANS_ATOB,"symmetry","Symmetry","Performs a symmetry (mirror) along the x/y axis, or both, on the current time selection of the Input track and pastes it in the Output track.");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Type of symmetry", Param.TYPE_COMBO, 0, "sym"));
		setCategory(Algorithm.CAT_TRANS_SPAT);
	}
	
	protected void treatOneTrack(int tkNth){}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		gp.Copy(tkNthFrom);
		HoloPoint curPt;
		for (int i = 0; i < gp.copyTrack.size(); i++)
		{
			curPt = gp.copyTrack.elementAt(i);
			switch ((Integer) results[3])
			{
			// Symetrie centrale
			case 0:
				curPt.x = -curPt.x;
				curPt.y = -curPt.y;
				break;
			// Symetrie horizontale
			case 1:
				curPt.y = -curPt.y;
				break;
			// Symetrie verticale
			case 2:
				curPt.x = -curPt.x;
				break;
			}
			inc();
		}
		gp.ReplaceWithoutStore(tkNthTo);
		gp.copyTrack = tmpTrack.dupliquer();
		gp.update(tkNthTo, -1);
	}
	
	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo){}
}
