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

import holoedit.functions.Algorithm;
import holoedit.gui.GestionPistes;
import holoedit.data.HoloTraj;
import holoedit.data.HoloTrack;
import holoedit.functions.ScriptEditorFunctions;
import holoedit.util.Ut;

import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilationFailedException;

public class GroovyConnector extends Algorithm
{
	private Binding	binding; 

	private GestionPistes gp;	
	
	public GroovyConnector(GestionPistes gp) {
		super(gp,Algorithm.TYPE_DATA,"Script","Script"," ");
		setCategory(CAT_SCRIPT);
		binding = new Binding();
	    // Création d'un paramètre
		this.gp = gp;
		ScriptEditorFunctions.gp[0] = this.gp;
	    binding.setVariable("gp", gp);	 
	    binding.setVariable("algo", this);	    
	}
	
	public boolean startGroovyScript(File file, int[] results)
	{
		GroovyShell shell = new GroovyShell();
		Script script;
		try {
		    script = shell.parse(file);// Chargement du script groovy
			script.setBinding(binding);
			
			int type = (Integer)results[0]; // type of algo : generation or transformation
		    int applyTo = (Integer)results[1];
			int tkNthTo = (Integer)results[2]-1; //-1 cause first item is just the string "n°"
			int inputTrack = (Integer)results[3]-1;
			int outputTrack = (Integer)results[4]-1;
			
			if (type==0){	// generative algo
				gp.Copy(tkNthTo); // FIXME : patch charlie
			    Object[] returnedValues = (Object[]) script.run();	// Exécution du script
			    HoloTraj ht = (HoloTraj) returnedValues[0];
			    double dur = (Double) returnedValues[1];
				dateBegin = (Integer)returnedValues[2];
				if (applyTo == 0){ // apply to one
					gp.StoreToUndo(tkNthTo);
					finalizeTraj(tkNthTo, ht, (int) dur);
				}else{ // apply to visible or to all
					gp.StoreToUndoAll();
					for (int i = 0; i < gp.getNbTracks(); i++)
						if (gp.getTrack(i).isVisible() || applyTo == 2)
								finalizeTraj(i, ht.dupliquer(), (int) dur);
				}
			}else if (type==1){	// transformation
				HoloTrack tmpTrack = gp.copyTrack.dupliquer(); // on remplace temporairement
				if (applyTo == 0){ // apply to one
					gp.StoreToUndo(tkNthTo);
					gp.Copy(inputTrack);
					script.run();	// Exécution du script
					gp.ReplaceWithoutStore(outputTrack);
					gp.copyTrack = tmpTrack.dupliquer();
					gp.update(outputTrack, -1);
					gp.selectTrack(outputTrack);
				}else { // apply to visible or to all
					gp.StoreToUndoAll();
					 for (int i = 0; i < gp.getNbTracks(); i++)
						if ((gp.getTrack(i).isVisible() || applyTo == 2) && !gp.getTrack(i).isEmpty()){
							gp.Copy(i);
							script.run();	// Exécution du scripts
							gp.ReplaceWithoutStore(i);
							gp.copyTrack = tmpTrack.dupliquer();
							gp.update(i, -1);
							gp.selectTrack(i);
						}
				}
			}
			return true;
		}catch (CompilationFailedException e) {
			Ut.showError(e);
			return false;
		} catch (Exception e) {
			Ut.showError(e);
			return false;
		} 
	}
    
    public void showWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Groovy-error", JOptionPane.WARNING_MESSAGE);
    }

	public void setReplace(boolean rep)	{
		replace = rep;
	}
	protected void treatOneTrack(int tkNth) {}

	protected void treatOneTrack(int tkNthFrom, int tkNthTo) {}

	protected void treatOneTrack(int tkNthFromA, int tkNthFromB, int tkNthTo) {}
	
}
