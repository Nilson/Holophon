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

import holoedit.data.HoloSpeaker;
import holoedit.functions.Algorithm;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import java.util.Vector;

public class SpeakerRect extends Algorithm
{
	public SpeakerRect(GestionPistes gp)
	{
		super(gp,TYPE_SPEAKERS,"speaker_rectangle","Rectangular Speakers","Sets a parameterizable number of speakers in two columns spaced by 'L-R distance'.\nThe distance between each speaker in a column is 'Y distance'.");
		addField(new Field("Number", Param.TYPE_INT, 8, 1, 32));
		addField(new Field("L-R distance", Param.TYPE_DOUBLE, 20., 0, 700));
		addField(new Field("Y distance", Param.TYPE_DOUBLE, 10., 0, 700));
		addField(new Field("Shift bottom", Param.TYPE_DOUBLE, 0., -700, 700));
		addField(new Field("Height", Param.TYPE_FLOAT, 0f, 0, 100));
		addField(new Field("Topleft number", Param.TYPE_INT, 1, 1, 32));
		addField(new Field("Stereo Pair Order",false));
		setCategory(CAT_GEN_SPEAKERS);
	}

	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
	
	protected void treatSpeakers()
	{
				// Recuperation des parametres de l'utilisateur
		int nHP = (Integer) results[0];
		double Xdist = (Double)results[1];
		double Ydist = (Double)results[2];
		double shift = (Double)results[3];
		float height = (Float) results[4];
		int numHP1 = (Integer) results[5];
		boolean stereoOrder = (Boolean)results[6];
		int lastHP = (replace ? 0 : gp.speakers.size()-1);
		int numHP;
		int rangees = (nHP / 2);
		float X, Y;
		if(replace) gp.speakers = new Vector<HoloSpeaker>(nHP);
		numHP1 = (evenp(nHP) ? numHP1 : 1 + numHP1);
		// Creation des HPs en fonction de ces parametres
		for (int i = 1; i <= rangees; i++)
			{
				// on part du haut a droite, on descend puis on remonte
				
				X = (float) (-Xdist);
				Y = (float) (shift + (Ydist * (rangees - 1) * 0.5) - (Ydist * (i - 1)));
				if(stereoOrder)
					numHP = numHP1+(i-1)*2;
				else
					numHP = (numHP1 + rangees + rangees - i) % nHP + 1;
				gp.speakers.add(new HoloSpeaker(X, Y, height, numHP+lastHP,-1));
				
				X = (float) (Xdist);
				Y = (float) (shift + (Ydist * (rangees - 1) * 0.5) - (Ydist * (i - 1)));
				if(stereoOrder)
					numHP = numHP1+(i-1)*2+1;
				else
					numHP = (numHP1 + i - 1) % nHP + 1;
				gp.speakers.add(new HoloSpeaker(X, Y, height, numHP+lastHP,-1));
				inc();
			}

			if (!evenp(nHP))
			{
			X = 0;
			Y = (float) (shift + (Ydist * (rangees - 1) * 0.5));
			numHP = ((numHP1 - 1) % nHP) + 1;
			gp.speakers.add(new HoloSpeaker(X, Y, height, numHP+lastHP,-1));
		}
	}
	
	public boolean evenp(int n)
	{
		int demiN = n / 2;
		return n == 2 * demiN;
	}
}
