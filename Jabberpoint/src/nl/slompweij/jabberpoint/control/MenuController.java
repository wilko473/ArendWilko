package nl.slompweij.jabberpoint.control;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import nl.slompweij.jabberpoint.view.AboutBox;
import nl.slompweij.jabberpoint.view.LabelsBundle_en_US;

/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	//private PresentationController presentationController;
	
	private static final long serialVersionUID = 227L;
	
	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";
	
	// TODO: Labels
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";

	public MenuController(Frame frame, final PresentationController presentationController) {
		parent = frame;
		//this.presentationController = presentationController;
		
		final ResourceBundle labels = new LabelsBundle_en_US();// TODO: ResourceBundle.getBundle("LabelsBundle");
		
		MenuItem menuItem;
		Menu fileMenu = new Menu(labels.getString(LabelsBundle_en_US.Label.FILE.name()));
		fileMenu.add(menuItem = mkMenuItem(LabelsBundle_en_US.Label.OPEN.name()));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: fix dit!
			//	presentation.clear();
//				Accessor xmlAccessor = new XMLAccessor();
//				try {
//					xmlAccessor.loadFile(presentationController, TESTFILE);
//					presentationController.setSlideNumber(0);
//				} catch (IOException exc) {
//					JOptionPane.showMessageDialog(parent, IOEX + exc, 
//         			LOADERR, JOptionPane.ERROR_MESSAGE);
//				}
//				parent.repaint();
			}
		} );
		fileMenu.add(menuItem = mkMenuItem(labels.getString(LabelsBundle_en_US.Label.NEW.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: fix dit
				//presentation.clear();
				parent.repaint();
			}
		});
		fileMenu.add(menuItem = mkMenuItem(labels.getString(LabelsBundle_en_US.Label.SAVE.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
//				Accessor xmlAccessor = new XMLAccessor();
//				try {
//					xmlAccessor.saveFile(presentation, SAVEFILE);
//				} catch (IOException exc) {
//					JOptionPane.showMessageDialog(parent, IOEX + exc, 
//							SAVEERR, JOptionPane.ERROR_MESSAGE);
//				}
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem(labels.getString(LabelsBundle_en_US.Label.EXIT.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: applicationController.exit(0);
			}
		});
		add(fileMenu);
		Menu viewMenu = new Menu(labels.getString(LabelsBundle_en_US.Label.VIEW.name()));
		viewMenu.add(menuItem = mkMenuItem(labels.getString(LabelsBundle_en_US.Label.NEXT.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationController.nextSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(labels.getString(LabelsBundle_en_US.Label.PREV.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationController.previousSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(labels.getString(LabelsBundle_en_US.Label.GOTO.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)labels.getString(LabelsBundle_en_US.Label.PAGENR.name()));
				int pageNumber = Integer.parseInt(pageNumberStr);
				presentationController.setSlideNumber(pageNumber - 1);
			}
		});
		add(viewMenu);
		Menu helpMenu = new Menu(labels.getString(LabelsBundle_en_US.Label.HELP.name()));
		helpMenu.add(menuItem = mkMenuItem(labels.getString(LabelsBundle_en_US.Label.ABOUT.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(parent);
			}
		});
		setHelpMenu(helpMenu);		// nodig for portability (Motif, etc.).
	}

// een menu-item aanmaken
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
