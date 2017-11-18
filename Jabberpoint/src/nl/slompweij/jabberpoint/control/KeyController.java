package nl.slompweij.jabberpoint.control;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/** <p>This is the KeyController (KeyListener)</p>
 * Is responsible for pressing keys.
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/13 Arend and Wilko
*/

public class KeyController extends KeyAdapter {
	

	private ApplicationController applicationController;
	
	public KeyController(ApplicationController applicationController) {
		this.applicationController = applicationController;
	}
	
	
}
