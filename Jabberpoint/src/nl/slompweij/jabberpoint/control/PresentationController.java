package nl.slompweij.jabberpoint.control;

import nl.slompweij.jabberpoint.factory.ThemeFactory;
import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Theme;

public class PresentationController {

	private Presentation presentation = null;
	//private int currentSlide;
	//private ViewController viewController = null;
	
	public PresentationController(Presentation presentation/*, int currentSlide*/) {
		this.presentation = presentation;
		//this.currentSlide = currentSlide;
	}
	
	public void nextSlide() {
//		if (currentSlide < presentation.getNumberOfSlides() - 1) {
//			currentSlide++;
//			viewController.updateView();
//		}
		presentation.nextSlide();
	}

	public void previousSlide() {
//		if (currentSlide > 0) {
//			currentSlide--;
//			viewController.updateView();
//		}
		presentation.previousSlide();
	}

	public void setCurrentSlideNumber(int newSlideNumber) {
//		if (newSlide > -1 && newSlide < presentation.getNumberOfSlides() - 1) {
//			this.currentSlide = newSlide;
//			viewController.updateView();
//		}
		presentation.setCurrentSlideNumber(newSlideNumber);
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation p) {
		// TODO Auto-generated method stub
		presentation = p;
		setCurrentSlideNumber(0);
		
	}

	public Theme getTheme() {
		// TODO Auto-generated method stub
		return ThemeFactory.createTheme();
	}

//	public int getCurrentSlide() {
//		return currentSlide;
//	}

//	public void setViewController(ViewController viewController) {
//		this.viewController = viewController;
//	}
	
	
}
