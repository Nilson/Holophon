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

public class SpeakerCircle extends Algorithm
{
	public SpeakerCircle(GestionPistes gp)
	{
		super(gp,TYPE_SPEAKERS,"speaker_circle","Circular Speakers","Sets a parameterizable number of speakers in circle.");
		addField(new Field("Number", Param.TYPE_INT, 8, 1, 32));
		addField(new Field("Radius", Param.TYPE_DOUBLE, 40., 0, 700));
		addField(new Field("Initial angle", Param.TYPE_DOUBLE, 112.5, -360, 360, 360));
		addField(new Field("Height", Param.TYPE_FLOAT, 0f, 0, 100));
		addField(new Field("Direction", Param.TYPE_COMBO, 0, "clock"));
		addField(new Field("Stereo Pair Order", false));
		setCategory(CAT_GEN_SPEAKERS);
	}

	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
	
	protected void treatSpeakers()
	{
		// Recuperation des parametres de l'utilisateur
		int nHP = (Integer) results[0];
		double dist = (Double) results[1];
		double dir, dir0 = (Double) results[2];
		float height = (Float) results[3];
		int sens = (Integer) results[4] > 0 ? -1 : 1;
		boolean stereoOrder = (Boolean)results[5];
		if(replace) gp.speakers = new Vector<HoloSpeaker>(nHP);
		int lastHP = (replace ? 0 : gp.speakers.size()-1);
		float dirStep = 360.f / nHP;
		// Creation des HPs en fonction de ces parametres
		if(stereoOrder)
		{
			for (int i = 1; i <= nHP; i+=2)
			{
				dir = dir0 + ((float) (i - 1)/2) * (-sens ) * dirStep;
				gp.speakers.add(new HoloSpeaker((float) dir, (float) dist, true, i+lastHP, height));
				inc();
			}
			dir0 = dir0 + sens * dirStep;
			for (int i = 2; i <= nHP; i+=2)
			{
				dir = dir0 + (float) (i - 2)/2 * sens * dirStep;
				gp.speakers.add(new HoloSpeaker((float) dir, (float) dist, true, i+lastHP, height));
				inc();
			}
		}
		else
			for (int i = 1; i <= nHP; i++)
			{
				dir = dir0 + ((float) (i - 1)) * sens * dirStep;
				gp.speakers.add(new HoloSpeaker((float) dir, (float) dist, true, i+lastHP, height));
				inc();
			}
	}
}
