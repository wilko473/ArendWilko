package nl.slompweij.jabberpoint.control;

import java.io.IOException;

import javax.swing.JOptionPane;

import nl.slompweij.jabberpoint.factory.PresentationFactory;
import nl.slompweij.jabberpoint.factory.ThemeFactory;
import nl.slompweij.jabberpoint.model.*;
import nl.slompweij.jabberpoint.view.SlideViewerFrame;


public class ApplicationController {
	// TODO: Remove deze static strings
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	private Presentation presentation;
	private PresentationController presentationController;
	private KeyController keyController;
	private SlideViewerFrame frame;
	private Theme theme;
	
	public ApplicationController(String[] args) {
		
		theme = ThemeFactory.createTheme();
		presentation=null;
		
		presentationController = new PresentationController(theme);
		keyController = new KeyController(this);
		frame = new SlideViewerFrame(JABVERSION, this);
		loadPresentation(args);
		
		frame.addKeyListener(keyController);
		
		presentation.setCurrentSlideNumber(0);
		
	}
	
	
	public void setTheme(Theme theme)
	{
		this.theme = theme;
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
		
		try {
			presentation = PresentationFactory.createPresentation(params);
			presentationController.setPresentation(presentation);
			
			frame.observe(presentation);
			
			
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			//ex.printStackTrace();
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}		
	}

	public void setCurrentSlideNumber(int i) {		
		presentationController.setCurrentSlideNumber(i);
	}


	public void setTheme(int optie) {
		presentationController.setTheme(ThemeFactory.getPredefined(optie));
		JOptionPane.showMessageDialog(null, "Hallo"+ optie);
		// TODO Auto-generated method stub
		
	}
}
