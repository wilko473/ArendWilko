package nl.slompweij.jabberpoint.control;

import nl.slompweij.jabberpoint.model.Presentation;

public class PresentationController {

	private Presentation presentation;
	private int currentSlide;
	
	public PresentationController(Presentation presentation, int currentSlide) {
		this.presentation = presentation;
		this.currentSlide = currentSlide;
	}
	
	public void nextSlide() {
		if (currentSlide < presentation.getSize() - 1) {
			currentSlide++;
		}
	}

	public void previousSlide() {
		if (currentSlide > 0) {
			currentSlide--;
		}
	}

	public void setSlideNumber(int newSlide) {
		if (newSlide > -1 && newSlide < presentation.getSize() - 1) {
			this.currentSlide = newSlide;
		}
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public int getCurrentSlide() {
		return currentSlide;
	}
}
