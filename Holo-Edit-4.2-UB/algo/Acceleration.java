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

public class Acceleration extends Algorithm
{
	public Acceleration(GestionPistes gp)
	{
		super(gp,TYPE_TRANS_ATOB,"acceleration","Acceleration","Accelerates or decelerates the current time selection of the Input track in time and pastes it in the Output track.\n(>0 acceleration / <0 deceleration)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		addField(new Field("Coefficient [-50:50]", Param.TYPE_DOUBLE, 30., -50, 50));
		setCategory(CAT_TRANS_TIME);
	}

	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
		gp.Copy(tkNthFrom);
		double coeffAcceleration = Ut.clip(50+(Double)results[3], 0.5, 99.5);
		int dateDebut = gp.copyTrack.getFirstDate();
		int dateFin = gp.copyTrack.getLastDate();
		double rapportTemps = (coeffAcceleration / 100);
		double rapportIndice = (0.5);
		double coeffHyperbole = calculCoeffHyperbole(rapportIndice, rapportTemps);
		int imax = gp.copyTrack.getLastPoint();
		for (int i = 0; i <= imax; i++)
		{
			double rapportIndice2 = (double) i / imax;
			double valHyperbole = calculValHyperbole(rapportIndice2, coeffHyperbole);
			HoloPoint hpi = gp.copyTrack.elementAt(i);
			hpi.date = dateDebut + (int) (valHyperbole * (dateFin - dateDebut));
			inc();
		}
		gp.ReplaceWithoutStore(tkNthTo);
		gp.update(tkNthTo, -1);
		gp.copyTrack = tmpTrack.dupliquer();
	}

	private double calculCoeffHyperbole(double x, double y)
	{
		double res;
		res = (y * (x - 1)) / (x * (y - 1));
		return res;
	}

	private double calculValHyperbole(double x, double n)
	{
		double res;
		if (n == 0)
		{
			res = x;
		}
		else
		{
			res = (n * x) / (1 + x * (n - 1));
		}
		return res;
	}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}