package nl.slompweij.jabberpoint.factory;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NodeList;

import nl.slompweij.jabberpoint.model.ConcreteTheme;
import nl.slompweij.jabberpoint.model.Style;
import nl.slompweij.jabberpoint.model.Theme;

public class ThemeFactory {
	// TODO: Multiple themes, parameters
	public static Theme createTheme() {
		List<Style> styles = new ArrayList<Style>();    
		// Hard coded styles
		styles.add(StyleFactory.createStyle(0, Color.red,   48, 20));
		styles.add(StyleFactory.createStyle(20, Color.blue,  40, 10));
		styles.add(StyleFactory.createStyle(50, Color.black, 36, 10));
		styles.add(StyleFactory.createStyle(70, Color.black, 30, 10));
		styles.add(StyleFactory.createStyle(90, Color.black, 24, 10));
		
//		styles[0] = new Style(0, Color.red,   48, 20);	// style voor item-level 0
//		styles[1] = new Style(20, Color.blue,  40, 10);	// style voor item-level 1
//		styles[2] = new Style(50, Color.black, 36, 10);	// style voor item-level 2
//		styles[3] = new Style(70, Color.black, 30, 10);	// style voor item-level 3
//		styles[4] = new Style(90, Color.black, 24, 10);	// style voor item-level 4

		return new ConcreteTheme("theme1", styles);
	}

	public Theme createTheme(NodeList theme) {
		List<Style> styles = new ArrayList<Style>();
		
		return new ConcreteTheme("theme1", styles);
	}
	
	
}
