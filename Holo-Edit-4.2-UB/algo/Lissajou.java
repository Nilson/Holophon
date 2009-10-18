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

public class Lissajou extends Algorithm
{
	public Lissajou(GestionPistes gp)
	{
		super(gp,TYPE_GEN,"lissajou","Lissajou","Generates a Lissajou curve. On each axis, a different sinusoidal wave drives the curve with initial and final properties (frequency,amplitude,phase).\n(Continue pastes it at the end, Replace replaces it)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Duration (sec)", Param.TYPE_DOUBLE, 20., 0.01, Double.MAX_VALUE));
		addField(new Field("Time resolution (sec)", Param.TYPE_DOUBLE, 0.1, 0.01, Double.MAX_VALUE));
		addField(new Field("Initial frequency on X", 0.1));
		addField(new Field("Final frequency on X", 0.3));
		addField(new Field("Initial frequency on Y", 0.3));
		addField(new Field("Final frequency on Y", 0.05));
		addField(new Field("Initial frequency on Z", 0.02));
		addField(new Field("Final frequency on Z", 0.45));
		addField(new Field("Initial amplitude on X", 50.));
		addField(new Field("Final amplitude on X", 0.));
		addField(new Field("Initial amplitude on Y", 50.));
		addField(new Field("Final amplitude on Y", 0.));
		addField(new Field("Initial amplitude on Z", Param.TYPE_DOUBLE, 100., HoloPoint.LOWLIMZ, HoloPoint.UPLIMZ));
		addField(new Field("Final amplitude on Z", Param.TYPE_DOUBLE, 0., HoloPoint.LOWLIMZ, HoloPoint.UPLIMZ));
		addField(new Field("Phasis on X [-1:1]", 0.5));
		addField(new Field("Phasis on Y [-1:1]", 0.));
		addField(new Field("Phasis on Z [-1:1]", 0.25));
		addField(new Field("Enable Z", false));
		setCategory(CAT_GEN);
	}

	protected void treatOneTrack(int tkNth)
	{
		HoloTraj ht = new HoloTraj();
		HoloPoint curPt = new HoloPoint();
		// --- parametres fournis par l'utilisateur :
		float X, Y, Z;
		double FX, FXi, FXf, FY, FYi, FYf, FZ, FZi, FZf, AX, AXi, AXf, AY, AYi, AYf, AZ, AZi, AZf, PHX, PHY, PHZ;
		double dur = (Double)results[2]; // en sec.
		double durPoint = (Double)results[3]; // 1/100e sec
		// --- initialisation -----
		FXi = (Double)results[4];
		FXf = (Double)results[5];
		FYi = (Double)results[6];
		FYf = (Double)results[7];
		FZi = (Double)results[8];
		FZf = (Double)results[9];
		AXi = (Double)results[10];
		AXf = (Double)results[11];
		AYi = (Double)results[12];
		AYf = (Double)results[13];
		AZi = (Double)results[14];
		AZf = (Double)results[15];
		PHX = (Double)results[16];
		PHY = (Double)results[17];
		PHZ = (Double)results[18];
		boolean enableZ = (Boolean)results[19];
		double curTime;
		int n;
		for (n = 0, curTime = 0; curTime <= dur; n++, curTime = n * durPoint)
		{
			FX = Ut.interpol(FXi, FXf, (curTime / dur));
			FY = Ut.interpol(FYi, FYf, (curTime / dur));
			FZ = Ut.interpol(FZi, FZf, (curTime / dur));
			AX = Ut.interpol(AXi, AXf, (curTime / dur));
			AY = Ut.interpol(AYi, AYf, (curTime / dur));
			AZ = Ut.interpol(AZi, AZf, (curTime / dur));
			X = (float) (AX * Math.sin((2 * Math.PI * curTime * FX) + Math.PI * PHX));
			Y = (float) (AY * Math.sin((2 * Math.PI * curTime * FY) + Math.PI * PHY));
			Z = enableZ ? (float) (0.5 * Math.sin((2 * Math.PI * curTime * FZ) + Math.PI * PHZ) * AZ + AZ * 0.5) : 0;
			// Main.print("Z:"+Z);
			curPt = new HoloPoint(X, Y, Z, (int) (100 * (curTime + dateBegin / 100.)));
			ht.addElement(curPt);
			inc();
		}
		finalizeTraj(tkNth, ht, (int) dur * 100);
	}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
