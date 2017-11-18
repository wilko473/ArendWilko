package nl.slompweij.jabberpoint.factory;

import java.io.IOException;

import javax.swing.JOptionPane;

import nl.slompweij.jabberpoint.io.Accessor;
import nl.slompweij.jabberpoint.io.DemoPresentation;
import nl.slompweij.jabberpoint.io.XMLAccessor;
import nl.slompweij.jabberpoint.model.Presentation;

public class PresentationFactory {
	
	public static Presentation createPresentation(String[] parameters) throws IOException {
		Presentation result = null;
		if (parameters == null || parameters.length == 0) {
			result = new DemoPresentation().loadPresentation("");
		} else {
			Accessor accessor = new XMLAccessor();
			
			result = accessor.loadPresentation(parameters[0]);
			
		}
		return result;
	}
	
	
	public static void savePresentation(Presentation presentation, String filename) {
		Accessor accessor = new XMLAccessor();
		try {
			accessor.saveFile(presentation, filename);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "bestand kan niet worden opgeslagen");
			
		}
	}
}
