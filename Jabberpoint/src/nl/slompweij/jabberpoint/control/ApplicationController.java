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
		try {
			presentation = PresentationFactory.createPresentation(args, theme);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		presentationController = new PresentationController(presentation);
		keyController = new KeyController(this);
		
		frame = new SlideViewerFrame(JABVERSION, this);
		frame.addKeyListener(keyController);
		
		frame.observe(presentation);
		
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

	public void loadPresentation(String name) {
		// TODO Auto-generated method stub
		String[] param = new String[] { name};
		try {
			Presentation p = PresentationFactory.createPresentation(param, theme);
			presentationController.setPresentation(p);
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
