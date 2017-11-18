package nl.slompweij.jabberpoint.view;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import nl.slompweij.jabberpoint.control.ApplicationController;
import nl.slompweij.jabberpoint.resource.LabelsBundle;

/**
 * <p>
 * The menu bar for the JabberPoint application.
 * </p>
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class JabberMenuComponent extends MenuBar {

	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs

	private static final long serialVersionUID = 227L;

	public JabberMenuComponent(final Frame frame, final ApplicationController applicationController) {
		parent = frame;

		final ResourceBundle labels = ResourceBundle.getBundle("nl.slompweij.jabberpoint.resource.LabelsBundle",
				LabelsBundle.SUPPORTED_LOCALES_en_US);

		MenuItem menuItem;
		Menu fileMenu = new Menu(labels.getString(LabelsBundle.Label.FILE.name()));
		fileMenu.add(menuItem = createMenuItem(labels.getString(LabelsBundle.Label.OPEN.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				JFileChooser fc = new JFileChooser();
				int result = fc.showDialog(parent, null);
				if (result == 0) {
					applicationController.loadPresentation(new String[] { fc.getSelectedFile().getAbsolutePath() });
				}
			}
		});

		fileMenu.add(menuItem = createMenuItem(labels.getString(LabelsBundle.Label.SAVE.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(parent);
				applicationController.savePresentation(fc.getName());
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(menuItem = createMenuItem(labels.getString(LabelsBundle.Label.EXIT.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				applicationController.exitApplication();
			}
		});
		add(fileMenu);
		Menu viewMenu = new Menu(labels.getString(LabelsBundle.Label.VIEW.name()));
		viewMenu.add(menuItem = createMenuItem(labels.getString(LabelsBundle.Label.NEXT.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				applicationController.nextSlide();
			}
		});

		viewMenu.add(menuItem = createMenuItem(labels.getString(LabelsBundle.Label.PREV.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				applicationController.previousSlide();
			}
		});
		viewMenu.add(menuItem = createMenuItem(labels.getString(LabelsBundle.Label.GOTO.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane
						.showInputDialog((Object) labels.getString(LabelsBundle.Label.PAGENR.name()));
				int pageNumber = Integer.parseInt(pageNumberStr);
				applicationController.setCurrentSlideNumber(pageNumber - 1);
			}
		});
		
		Menu themeMenu = new Menu("Theme");
		class ThemeAction implements ActionListener {
			private int optie;
			private ApplicationController app;

			public ThemeAction(int optie, ApplicationController app) {
				this.app = app;
				this.optie = optie;
			}

			public void actionPerformed(ActionEvent arg0) {
				app.setTheme(optie);
			}

		}

		themeMenu.add(menuItem = createMenuItem("A Stijl"));
		menuItem.addActionListener(new ThemeAction(1, applicationController));

		themeMenu.add(menuItem = createMenuItem("B Stijl"));
		menuItem.addActionListener(new ThemeAction(2, applicationController));

		themeMenu.add(menuItem = createMenuItem("C Stijl"));
		menuItem.addActionListener(new ThemeAction(3, applicationController));

		themeMenu.add(menuItem = createMenuItem("D Stijl"));
		menuItem.addActionListener(new ThemeAction(4, applicationController));

		viewMenu.add(themeMenu);
		
		add(viewMenu);
		Menu helpMenu = new Menu(labels.getString(LabelsBundle.Label.HELP.name()));
		helpMenu.add(menuItem = createMenuItem(labels.getString(LabelsBundle.Label.ABOUT.name())));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(parent);
			}
		});
		setHelpMenu(helpMenu);
	}

	private MenuItem createMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
