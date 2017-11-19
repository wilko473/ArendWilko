package nl.slompweij.jabberpoint.factory;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import nl.slompweij.jabberpoint.model.ConcreteTheme;
import nl.slompweij.jabberpoint.model.SlideItem;
import nl.slompweij.jabberpoint.model.Style;
import nl.slompweij.jabberpoint.model.Theme;

public class ThemeFactory {

	public static Theme createDefaultTheme() {
		return getPredefined(1);
	}

	private static Font createFont(String fontname, int type, int size) {
		return new Font(fontname, type, size);
	}
	
	public static Theme createTheme(NodeList theme, NodeList styleList, NodeList defaultItems, String bgColor) {
		List<Style> styles = new ArrayList<Style>();
		List<SlideItem> items = new ArrayList<SlideItem>();
		
		for (int i = 0; i < styleList.getLength(); i++) {
			NamedNodeMap attributes = styleList.item(i).getAttributes();
			String level = attributes.getNamedItem("level").getTextContent();
			String color = attributes.getNamedItem("color").getTextContent();
			String fontSize = attributes.getNamedItem("font-size").getTextContent();
			String fontName = attributes.getNamedItem("font-face").getTextContent();
			String leadingStr = attributes.getNamedItem("leading").getTextContent();
			int leading = Integer.parseInt(leadingStr);
			Font font = createFont(fontName, Font.BOLD, Integer.parseInt(fontSize));
			styles.add(StyleFactory.createStyle(Integer.parseInt(level), Color.decode(color), font, leading));
		}
		
		for (int i = 0; i < defaultItems.getLength(); i++) {
			items.add(SlideItemFactory.createSlideItem((Element) defaultItems.item(i)));
		}
		Theme result = new ConcreteTheme("theme1", styles, items);
		result.setBackgroundColour(Color.decode(bgColor));
		return result;
	}

	public static Theme getPredefined(int optie) {
		List<Style> styles = new ArrayList<Style>();
		// Hard coded styles
		String fname = "";
		switch (optie) {
		case 1:
			fname = "Helvetica";
			break;
		case 2:
			fname = "Times New Roman";
			break;
		case 3:
			fname = "Calibri";
			break;
		default:
			fname = "Arial";
			break;
		}
		styles.add(StyleFactory.createStyle(0, Color.red, createFont(fname, Font.BOLD, 48), 20));
		styles.add(StyleFactory.createStyle(20, Color.blue, createFont(fname, Font.BOLD, 40), 10));
		styles.add(StyleFactory.createStyle(50, Color.black, createFont(fname, Font.BOLD, 36), 10));
		styles.add(StyleFactory.createStyle(70, Color.black, createFont(fname, Font.BOLD, 30), 10));
		styles.add(StyleFactory.createStyle(90, Color.black, createFont(fname, Font.BOLD, 24), 10));

		return new ConcreteTheme("theme1", styles, null);
	}
}
