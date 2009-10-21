/*
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
import holoedit.data.HoloSDIFdata;
import java.lang.Math;

public class FromSDIF extends Algorithm
{
	float minX, maxX, dbX, minY, maxY, dbY, minZ, maxZ, dbZ;
	String[] sdifNames;
	
	public FromSDIF(GestionPistes gp)
	{
		super(gp,TYPE_DATA,"fromSDIF","FromSDIF","Generates a trajectory from sdif datas.\n......\n(Continue pastes it at the end, Replace replaces it)");
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Duration (sec)", Param.TYPE_DOUBLE, 20., 0.01, Double.MAX_VALUE));
		addField(new Field("Time resolution (sec)", Param.TYPE_DOUBLE, 0.1, 0.01, Double.MAX_VALUE));
		addField(new Field("min Angle (degrees)", Param.TYPE_DOUBLE, 0d, 0d, 360d));
		addField(new Field("max Angle (degrees)", Param.TYPE_DOUBLE, 360d, 0d, 360d));
		addField(new Field("From SDIF", Param.TYPE_COMBO, 0, "sdif"));
		addField(new Field("Map X", Param.TYPE_COMBO, 0, "sdifFields"));
		addField(new Field("From SDIF", Param.TYPE_COMBO, 0, "sdif"));
		addField(new Field("Map Y", Param.TYPE_COMBO, 0, "sdifFields"));
		addField(new Field("From SDIF", Param.TYPE_COMBO, 0, "sdif"));
		addField(new Field("Map Z", Param.TYPE_COMBO, 0, "sdifFields"));

		setCategory(CAT_DATA);
	}
		
	protected void treatOneTrack(int tkNth)
	{
		HoloTraj ht = new HoloTraj();
		HoloPoint curPt = new HoloPoint();
		double dur = (Double)results[2] * 1000; // 1/1000e sec
		double durPoint = (Double)results[3] * 1000; // 1/1000e sec
		int nbPoints = (int) (dur / durPoint);
		
		double minAngle = (Double) results[4]/360d*2d*Math.PI;
		double maxAngle = (Double) results[5]/360d*2d*Math.PI;
		double angleRange = maxAngle - minAngle;
		
		HoloSDIFdata holoSDIFdataX = null;
		HoloSDIFdata holoSDIFdataY = null;
		HoloSDIFdata holoSDIFdataZ = null;
		int XvaluesIndex=0, YvaluesIndex=0, ZvaluesIndex=0;
		double minX=0, maxX=0, meanX=0, rangeX=0, Xstep=0;
		double minY=0, maxY=0, meanY=0, rangeY=0, Ystep=0;
		double minZ=0, maxZ=0, meanZ=0, rangeZ=0, Zstep=0;
		// --- parametres fournis par l'utilisateur :
		String filename, dataType;
		String[] splitStr;
		String selectedSDIFforX = (String) results[6];

		if (!selectedSDIFforX.equalsIgnoreCase("none")) {
			splitStr = selectedSDIFforX.split("\\s"+"-"+"\\s"); // espace+tiret+espace
			filename = splitStr[0];
			dataType = splitStr[1];
			holoSDIFdataX = gp.externalDataPool.get(filename, dataType);
			XvaluesIndex = (Integer) results[7];// champs de la holoSDIFdata
			minX = holoSDIFdataX.getHoloDataStat().minVector.get(XvaluesIndex);
			maxX = holoSDIFdataX.getHoloDataStat().maxVector.get(XvaluesIndex);
			rangeX = holoSDIFdataX.getHoloDataStat().rangeVector.get(XvaluesIndex);
			Xstep = holoSDIFdataX.getDataLength()/nbPoints;
		}
		String selectedSDIFforY = (String) results[8];
		if (!selectedSDIFforY.equalsIgnoreCase("none")) {
			splitStr = selectedSDIFforX.split("\\s"+"-"+"\\s"); // espace+tiret+espace
			//splitStr = selectedSDIFforY.split("\\s"+"\\p{Punct}"+"\\s", 2);
			filename = splitStr[0];
			dataType = splitStr[1];
			holoSDIFdataY = gp.externalDataPool.get(filename, dataType);
			YvaluesIndex = (Integer) results[9];// champs de la holoSDIFdata
			minY = holoSDIFdataY.getHoloDataStat().minVector.get(YvaluesIndex);
			maxY = holoSDIFdataY.getHoloDataStat().maxVector.get(YvaluesIndex);
			rangeY = holoSDIFdataY.getHoloDataStat().rangeVector.get(YvaluesIndex);
			Ystep = holoSDIFdataY.getDataLength()/nbPoints;
		}
		String selectedSDIFforZ = (String) results[10];
		if (!selectedSDIFforZ.equalsIgnoreCase("none")) {
			splitStr = selectedSDIFforX.split("\\s"+"-"+"\\s"); // espace+tiret+espace		
			//splitStr = selectedSDIFforZ.split("\\s"+"\\p{Punct}"+"\\s", 2);
			filename = splitStr[0];
			dataType = splitStr[1];
			holoSDIFdataZ = gp.externalDataPool.get(filename, dataType);
			ZvaluesIndex = (Integer) results[11];// champs de la holoSDIFdata
			minZ = holoSDIFdataZ.getHoloDataStat().minVector.get(ZvaluesIndex);
			maxZ = holoSDIFdataZ.getHoloDataStat().maxVector.get(ZvaluesIndex);
			rangeZ = holoSDIFdataZ.getHoloDataStat().rangeVector.get(ZvaluesIndex);
			Zstep = holoSDIFdataZ.getDataLength()/nbPoints;	
		}

		double curTimePoint = 0;
		double curTimeX = 0;
		double curTimeY = 0;
		double curTimeZ = 0;
		
		for (int n = 0; n < nbPoints; n++)
		{
			curPt = new HoloPoint();
			curTimePoint = n * durPoint;
			curPt.date = (int) curTimePoint + dateBegin;
			if (holoSDIFdataX !=null){
				curTimeX = n * Xstep + holoSDIFdataX.getStartTime();
				// mean
/*				double mean=0;
				for (Vector<Double> vector : holoSDIFdataX.getDataAtTime(curTimeX))
					mean += vector.get(XvaluesIndex);
				mean /= holoSDIFdataX.getDataAtTime(curTimeX).size();
				curPt.x = HoloPoint.limit2D((float) polX(minAngle+(mean-minX)*angleRange/rangeX, 100d));
				//max
				curPt.x = HoloPoint.limit2D((float) polX(minAngle+(holoSDIFdataX.getDataAtTime(curTimeX).get(holoSDIFdataX.getDataAtTime(curTimeX).size()).get(XvaluesIndex).floatValue()-minX)*angleRange/rangeX, 100d));
*/				// min :
				curPt.x = HoloPoint.limit2D((float) polX(minAngle+(holoSDIFdataX.getDataAtTime(curTimeX).get(0).get(XvaluesIndex).floatValue()-minX)*angleRange/rangeX, 100d));
			} else 
				curPt.x = 0;
			
			if (holoSDIFdataY !=null){
				curTimeY = n * Ystep + holoSDIFdataY.getStartTime();
				curPt.y = HoloPoint.limit2D((float) polY(minAngle+(holoSDIFdataY.getDataAtTime(curTimeY).get(0).get(YvaluesIndex).floatValue()-minY)*angleRange/rangeY, 100d));
			} else 
				curPt.y = 0;
			
			if (holoSDIFdataZ !=null){
				curTimeZ = n * Zstep + holoSDIFdataZ.getStartTime();
				curPt.z = HoloPoint.limit2D((float) polX(minAngle+(holoSDIFdataZ.getDataAtTime(curTimeZ).get(0).get(ZvaluesIndex).floatValue()-minZ)*angleRange/rangeZ, 100d));
			} else 
				curPt.z = 0;
			
			ht.addElement(curPt);
			inc();
		}
		finalizeTraj(tkNth, ht, (int) dur);
	}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
}
