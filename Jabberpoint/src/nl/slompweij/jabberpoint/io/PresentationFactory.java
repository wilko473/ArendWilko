package nl.slompweij.jabberpoint.io;

import java.io.IOException;

import javax.swing.JOptionPane;

import nl.slompweij.jabberpoint.model.Presentation;

public class PresentationFactory {
	
	private static Accessor accessor = null;
	public static Presentation createPresentation(String[] parameters) throws IOException {
		Presentation result = null;
		
		if (parameters == null || parameters.length == 0) {
			accessor = new DemoPresentation();			
		} else {
			accessor = new XMLAccessor();			
		}
		result = accessor.loadPresentation(parameters);
		return result;
	}
	
	public static void savePresentation(Presentation presentation, String filename) {
		
		try {
			accessor.saveFile(presentation, filename);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to save the presentation."+e.getMessage());			
		}
	}
}
