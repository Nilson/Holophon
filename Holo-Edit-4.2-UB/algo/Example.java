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
import holoedit.data.HoloTraj;
import holoedit.functions.Algorithm;
import holoedit.functions.ButtonParam;
import holoedit.functions.Field;
import holoedit.functions.Param;
import holoedit.gui.GestionPistes;
import holoedit.util.Ut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 * This class does nothing but explain how algorithms work.
 */

// First an Algorithm extends the class holoedit.functions.Algorithm...
public class Example extends Algorithm
{
	// (added parameter)
	File selectedFile;
	
	// and has a constructor with a variable gp of the type GestionPistes
	public Example(GestionPistes gp)
	{
		// call of the super constructor with parameters :
		// * gp
		// * type : four different types : GEN, TRANS_ATOB, TRANS_ABTOC, SPEAKERS
		// * internal_name : name of the algorithm
		// * external_name : for use in the menu and in the title of the algorithm's dialog
		// * description : human readable description of the algorithm.
		super(gp,TYPE_TRANS_ATOB,"example","Example","...");
		
		// declaration of the parameters of your algorithm = field in the algorithm's dialog
		// depending on the type of the algorithm you want to implement you'll need to
		// add some parameters in a certain order
		//
		// TYPE_GEN :
//		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
//		addField(new Field("Track n" + Ut.numCar, Param.TYPE_COMBO, 1));
//		addField(new Field("Duration (sec)", Param.TYPE_DOUBLE, 20., 0.01, Double.MAX_VALUE));
//		addField(new Field("Time resolution (sec)", Param.TYPE_DOUBLE, 0.1, 0.01, Double.MAX_VALUE));

		// TYPE_TRANS_ATO_B
		addField(new Field("Apply To", Param.TYPE_COMBO, 0, "applyTo"));
		addField(new Field("Input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 2));
		
		// TYPE_TRANS_ABTOC
//		addField(new Field("A -> input track n" + Ut.numCar, Param.TYPE_COMBO, 1));
//		addField(new Field("-> B input track n" + Ut.numCar, Param.TYPE_COMBO, 2));
//		addField(new Field("Output track n" + Ut.numCar, Param.TYPE_COMBO, 3));

		// TYPE_SPEAKERS
//		addField(new Field("Number", Param.TYPE_INT, 8, 1, 32));
		
		// then you can add your own fields no matter the type you choose.
		// an integer with it's default value
		addField(new Field("Test Integer", 25));
		// a float
		addField(new Field("Test Float", 25f));
		// a float with constraints (min,max,modulo)
		addField(new Field("Min/Max/Mod Float", Param.TYPE_FLOAT, 25f, 0, 100, 25));
		// a double
		addField(new Field("Test Double", 25.));
		// a text field
		addField(new Field("Test Text", "testing..."));
		// a checkbox
		addField(new Field("Test Check", false));
		// a button with it's own action
		addField(new Field("Test Button", Param.TYPE_BUTTON, "Choose", new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(null);
				selectedFile = jfc.getSelectedFile();
				((ButtonParam)e.getSource()).setText("Ok");
			}
		}));
		
		// finally choose a category to sort your algorithms
		// existing categories are :
		// CAT_TRANS_SPAT = "Spatial Transformations";
		// CAT_TRANS_TIME = "Temporal Transformations";
		// CAT_GEN = "Generative Functions";
		// CAT_GEN_SPEAKERS = "Speakers";
		// CAT_OWN = "User Algorithms"; <-- default one
		// CAT_WIP = "Work In Progress";
		// CAT_MAC = "Macros";

		// but you can enter your own category as text.
		setCategory("Dev. Example");
	}
	
	// Then you need to implement your algorithm in one of the four following functions
	// called when the algorithm's dialog is validated.
	// it can be called several times if you apply your algorithm to several tracks.
	//
	// In order to understand how to manipulate tracks/trajectories/point
	// follow an existing example.
	
	// called when type = TYPE_GEN
	protected void treatOneTrack(int tkNth) 
	{
		HoloTraj ht = new HoloTraj();
		HoloPoint curPt;
		double dur = (Double)results[2] * 100; // 1/100e sec
		double durPoint = (Double)results[3] * 100; // 1/100e sec
		double curTime = 0;
		int nbPoints = (int) (dur / durPoint);
		for (int n = 0; n <= nbPoints; n++)
		{
			curTime = n * durPoint;
			curPt = new HoloPoint();
			curPt.date = (int) curTime + dateBegin;
			// modify curPt x,y and z attributes
			// curPt.x = 
			// curPt.y =
			// curPt.z =
			// add curPt to your trajectory
			ht.addElement(curPt);
			inc(); // <-- use this in order to tell the app you've done 1 one more point (for the progressbar)
		}
		// this will insert your trajectory on the destination track
		// at the end if you choose "Continue" else replace the current time selection.
		finalizeTraj(tkNth, ht, (int) dur);
	}

	// called when type = TYPE_TRANS_ATOB
	protected void treatOneTrack(int tkNthFrom, int tkNthTo)
	{
		// first we copy the copytrack in order not to loose it 
		HoloTrack tmpTrack = gp.copyTrack.dupliquer();
		// because we will use some copy/paste functions
		gp.Copy(tkNthFrom);
		
		// now the content of the input track between BEGIN & END is in the copy track. 
		
		// get the results of the algorithm's dialog.
		int int1 = (Integer)results[3];
		float f1 = (Float)results[4];
		float f2 = (Float)results[5];
		double d1 = (Double)results[6];
		String t1 = (String)results[7];
		boolean b1 = (Boolean)results[8];
		
		// now on each point of the copy track, do something		
		for (int i = 0; i < gp.copyTrack.size(); i++)
		{
			HoloPoint tempPt = gp.copyTrack.elementAt(i);
			// each point has several parameters;
			// tempPt.x;
			// tempPt.y;
			// tempPt.z;
			// tempPt.date;
			inc(); // <-- use this in order to tell the app you've done 1 one more point (for the progressbar)
		}
		
		// now we replace the destination track with the content of the copy track
		gp.ReplaceWithoutStore(tkNthTo);
		// and we restore the old copy track;
		gp.copyTrack = tmpTrack.dupliquer();
		// we update tracks, windows and time selection
		gp.update(tkNthTo, -1);
	}

	// called when type = TYPE_TRANS_ABTOC
	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
	
	// called when type = TYPE_SPEAKERS
	protected void treatSpeakers() {}
}
