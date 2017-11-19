package nl.slompweij.jabberpoint.view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import nl.slompweij.jabberpoint.control.ApplicationController;
import nl.slompweij.jabberpoint.control.PresentationObserver;
import nl.slompweij.jabberpoint.model.Presentation;

/**
 * <p>
 * The application window that contains the menubar and the slide viewer component.
 * </p>
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/16 Arend and Wilko
 */
public class SlideViewerFrame extends JFrame implements PresentationObserver {
	private static final long serialVersionUID = 3227L;
	private static final String JABTITLE = "Jabberpoint 2.0 - OU";

	private SlideViewerComponent slideViewerComponent = null;

	public SlideViewerFrame(String title, ApplicationController applicationController) {
		super(title);
		slideViewerComponent = new SlideViewerComponent();

		setupWindow(slideViewerComponent, applicationController);
	}

	private void setupWindow(SlideViewerComponent slideViewerComponent,
			final ApplicationController applicationController) {
		setTitle(JABTITLE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				applicationController.exitApplication();
			}
		});
		getContentPane().add(slideViewerComponent);

		setMenuBar(new JabberMenuComponent(this, applicationController));
		setSize(new Dimension(SlideViewerComponent.PREFERRED_WIDTH, SlideViewerComponent.PREFERRED_HEIGHT));
		setVisible(true);
	}

	@Override
	public void observe(Presentation presentation) {
		presentation.addObserver(slideViewerComponent);	
	}
}
