package nl.slompweij.jabberpoint.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import nl.slompweij.jabberpoint.io.PresentationFactory;
import nl.slompweij.jabberpoint.model.Theme;
import nl.slompweij.jabberpoint.model.ThemeFactory;

public class ApplicationController extends KeyAdapter {

	private PresentationController presentationController;
	private PresentationObserver presentationObserver = null;

	public ApplicationController(PresentationController presController) {
		presentationController = presController;
	}

	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_PAGE_DOWN:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_ENTER:
		case '+':
			nextSlide();
			break;
		case KeyEvent.VK_PAGE_UP:
		case KeyEvent.VK_UP:
		case '-':
			previousSlide();
			break;
		case 'q':
		case 'Q':
			exitApplication();
			break;
		default:
			break;
		}
	}

	public void setTheme(Theme theme) {
		presentationController.setTheme(theme);
	}

	public void exitApplication() {
		System.exit(0);
	}

	public void nextSlide() {
		presentationController.nextSlide();
	}

	public void previousSlide() {
		presentationController.previousSlide();
	}

	public void loadPresentation(String[] params) {
		presentationController.setPresentation(params);
		presentationObserver.observe(presentationController.getPresentation());
		presentationController.setCurrentSlideNumber(0);
	}

	public void savePresentation(String filename) {
		PresentationFactory.savePresentation(presentationController.getPresentation(), filename);
	}

	public void setCurrentSlideNumber(int i) {
		presentationController.setCurrentSlideNumber(i);
	}

	public void setTheme(int optie) {
		presentationController.setTheme(ThemeFactory.getPredefined(optie));
	}

	public void setPresentationObserver(PresentationObserver presentationObserver) {
		this.presentationObserver = presentationObserver;
	}
}
