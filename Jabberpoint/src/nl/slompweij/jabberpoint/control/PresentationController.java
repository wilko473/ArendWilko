package nl.slompweij.jabberpoint.control;

import java.io.IOException;

import nl.slompweij.jabberpoint.factory.PresentationFactory;
import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Theme;

public class PresentationController {

	private Presentation presentation = null;
	private Theme defaultTheme = null;
	
	
	public PresentationController(Theme defaultTheme) {
		this.defaultTheme = defaultTheme;
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

	/*public void setPresentation(Presentation p) {
		presentation = p;
		setCurrentSlideNumber(0);
		if (presentation.getTheme() == null) {
			presentation.setTheme(defaultTheme);
		}
	}*/

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCurrentSlideNumber(0);
		if (presentation.getTheme() == null) {
			presentation.setTheme(defaultTheme);
		}
		
	}	
	
}
