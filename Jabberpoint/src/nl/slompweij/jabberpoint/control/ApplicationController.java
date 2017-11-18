package nl.slompweij.jabberpoint.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import nl.slompweij.jabberpoint.factory.PresentationFactory;
import nl.slompweij.jabberpoint.factory.ThemeFactory;
import nl.slompweij.jabberpoint.model.Theme;
import nl.slompweij.jabberpoint.view.SlideViewerFrame;


public class ApplicationController extends KeyAdapter{
	// TODO: Remove deze static strings
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	
	private PresentationController presentationController;	
	private SlideViewerFrame frame;
	//private Theme theme;
	
	public ApplicationController(PresentationController presController) {
		
		presentationController = presController;
		
				
	}
	
	
	public void keyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
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
				ExitApplication();
				break;
			default:
				break;
		}
	}
	
	public void setTheme(Theme theme)
	{
		
		presentationController.setTheme(theme);
	}
	
	
	public void ExitApplication() {
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
			frame.observe(presentationController.getPresentation());
			presentationController.setCurrentSlideNumber(0);	
	}

	public void savePresentation(String filename)
	{
	    PresentationFactory.savePresentation(presentationController.getPresentation(), filename);
	}
	
	public void setCurrentSlideNumber(int i) {		
		presentationController.setCurrentSlideNumber(i);
	}


	public void setTheme(int optie) {
		presentationController.setTheme(ThemeFactory.getPredefined(optie));
	}


	public void setFrame(SlideViewerFrame frame) {
		this.frame = frame;
		
	}
}
