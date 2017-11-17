package nl.slompweij.jabberpoint.control;

import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Theme;

public class PresentationController {

	private Presentation presentation = null;
	private Theme theme = null;
	
	
	public PresentationController(Theme defaultTheme) {
		this.theme = defaultTheme;
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

	public void setPresentation(Presentation p) {
		presentation = p;
		setCurrentSlideNumber(0);
		if (presentation.getTheme() == null) {
			presentation.setTheme(theme);
		}
	}

	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
		presentation.setTheme(theme);
		
	}	
	
}
