package nl.slompweij.jabberpoint.main;

import nl.slompweij.jabberpoint.control.ApplicationController;
import nl.slompweij.jabberpoint.control.PresentationController;
import nl.slompweij.jabberpoint.factory.ThemeFactory;
import nl.slompweij.jabberpoint.view.SlideViewerFrame;

/** JabberPoint Main Programma
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/17 Arend en Wilko
 */

public class JabberPoint {
	
	
	private static final String JABVERSION = "2.0";

	/** Het Main Programma */
	public static void main(String args[]) {
		PresentationController presController = new PresentationController(ThemeFactory.createTheme());
		
		ApplicationController appController = new ApplicationController(presController, args);
		
		SlideViewerFrame frame = new SlideViewerFrame(JABVERSION, appController);
		appController.setFrame(frame);
		frame.addKeyListener(appController);
		appController.loadPresentation(args);
		
	}
}
