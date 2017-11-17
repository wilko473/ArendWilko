package nl.slompweij.jabberpoint.control;

import java.io.IOException;

import nl.slompweij.jabberpoint.factory.PresentationFactory;
import nl.slompweij.jabberpoint.factory.ThemeFactory;
import nl.slompweij.jabberpoint.model.*;
import nl.slompweij.jabberpoint.view.SlideViewerFrame;


public class ApplicationController {
	
	private static final String JABVERSION = "";
	private Presentation presentation;
	private PresentationController presentationController;
	private KeyController keyController;
	private SlideViewerFrame frame;
	private Theme theme;
	
	public ApplicationController(String[] args) {
		
		theme = ThemeFactory.createTheme();
		presentation=null;
		
		presentationController = new PresentationController();
		keyController = new KeyController(this);
		frame = new SlideViewerFrame(JABVERSION, this);
		loadPresentation(args);
		
		frame.addKeyListener(keyController);
		
		
		
		presentation.setCurrentSlideNumber(0);
		
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
		
		try {
			Presentation p = PresentationFactory.createPresentation(params, theme);
			presentationController.setPresentation(p);
			this.presentation  =p;
//			frame.observe(p);
			frame.observe(presentation);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void setCurrentSlideNumber(int i) {
		// TODO Auto-generated method stub
		presentationController.setCurrentSlideNumber(i);
	}
	

}
