package nl.slompweij.jabberpoint.control;

import java.io.IOException;

import javax.swing.JOptionPane;

import nl.slompweij.jabberpoint.factory.PresentationFactory;
import nl.slompweij.jabberpoint.factory.ThemeFactory;
import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Theme;

/**
 * Controller class for presentation related functionality.
 * @author Arend and Wilko
 */
public class PresentationController {

	private Presentation presentation = null;

	public PresentationController() {
	}

	public void nextSlide() {
		presentation.nextSlide();
	}

	public void previousSlide() {
		presentation.previousSlide();
	}

	public void setCurrentSlideNumber(int newSlideNumber) {
		presentation.setCurrentSlideNumber(newSlideNumber);
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public Theme getTheme() {
		return presentation.getTheme();
	}

	public void setTheme(Theme theme) {
		presentation.setTheme(theme);
	}

	public void setPresentation(String[] params) {
		try {
			presentation = PresentationFactory.createPresentation(params);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read file " + params[0] + ".");
		}
		setCurrentSlideNumber(0);
		if (presentation.getTheme() == null) {
			presentation.setTheme(ThemeFactory.createDefaultTheme());
		}
	}
}
