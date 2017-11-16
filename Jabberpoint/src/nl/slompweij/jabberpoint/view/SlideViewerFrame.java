package nl.slompweij.jabberpoint.view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;

import javax.swing.JFrame;

import nl.slompweij.jabberpoint.control.MenuController;
import nl.slompweij.jabberpoint.control.PresentationController;

/**
 * <p>Het applicatiewindow voor een slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/16 Arend and Wilko
*/

public class SlideViewerFrame extends JFrame {
	private static final long serialVersionUID = 3227L;
	
	private static final String JABTITLE = "Jabberpoint 1.6 - OU";// TODO: Naar Labels
	
	public final static int WIDTH = 1200;// TODO: WIDTH en HEIGHT zijn elders al gedefinieerd
	public final static int HEIGHT = 800;
	private SlideViewerComponent slideViewerComponent = null;
	
	public SlideViewerFrame(String title, PresentationController presentationController) {
		super(title);
		slideViewerComponent = new SlideViewerComponent();
		
		//presentation.setShowView(slideViewerComponent);
		setupWindow(slideViewerComponent, presentationController);
	}

// De GUI opzetten
	public void setupWindow(SlideViewerComponent 
			slideViewerComponent, PresentationController presentationController) {
		setTitle(JABTITLE);
		
		//TODO: naar controller
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		getContentPane().add(slideViewerComponent);
		
//		addKeyListener(new KeyController(presentation)); // een controller toevoegen
		setMenuBar(new MenuController(this, presentationController));	// nog een controller toevoegen
		setSize(new Dimension(WIDTH, HEIGHT)); // Dezelfde maten als Slide hanteert.
		setVisible(true);
	}
	
	// TODO: add listener to presentation creation
	public void observe(Observable presentation) {
		presentation.addObserver(slideViewerComponent);
	}
//	public void update() {
//		slideViewerComponent.repaint();
//	}
}
