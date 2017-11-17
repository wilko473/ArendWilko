package nl.slompweij.jabberpoint.factory;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;


import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import nl.slompweij.jabberpoint.model.ConcreteTheme;
import nl.slompweij.jabberpoint.model.Style;
import nl.slompweij.jabberpoint.model.Theme;

public class ThemeFactory {
	private static final String FONTNAME = "Helvetica";
		
	
	public static Theme createTheme() {
		List<Style> styles = new ArrayList<Style>();    
		// Hard coded styles
		styles.add(StyleFactory.createStyle(0, Color.red,  createFont(FONTNAME, Font.BOLD,  48), 20));
		styles.add(StyleFactory.createStyle(20, Color.blue,  createFont(FONTNAME, Font.BOLD,40), 10));
		styles.add(StyleFactory.createStyle(50, Color.black, createFont(FONTNAME, Font.BOLD,36), 10));
		styles.add(StyleFactory.createStyle(70, Color.black, createFont(FONTNAME, Font.BOLD,30), 10));
		styles.add(StyleFactory.createStyle(90, Color.black, createFont(FONTNAME, Font.BOLD,24), 10));
		
		return new ConcreteTheme("theme1", styles);
	}

	private static Font createFont(String fontname, int type, int size)
	{
		return new Font(fontname, type, size);
	}
	
	public Theme createTheme(NodeList theme, NodeList styleList) {
		/*
		 * <theme>
	   <background>#000000</background>
	   <styles>
	     <style level="1" color="#AABBCC" font-face="Times New Roman" font-size="20"/>
		 <style level="2" color="#3F2B3C" font-face="Times New Roman" font-size="15"/>
		 <style level="3" color="#482C00" font-face="Times New Roman" font-size="10"/>
		 <style level="3" color="#185C0A" font-face="Times New Roman" font-size="5"/>
		</styles>
	</theme>
		 */
		List<Style> styles = new ArrayList<Style>();
		
		for (int i=0; i< styleList.getLength(); i++)
		{
			NamedNodeMap attributes = styleList.item(i).getAttributes();
			String level = attributes.getNamedItem("level").getTextContent();
			String color = attributes.getNamedItem("color").getTextContent();
			String fontSize= attributes.getNamedItem("font-size").getTextContent();
			String fontName = attributes.getNamedItem("font-face").getTextContent();
			int leading = 3;
			Font font = new Font(fontName, Font.BOLD, Integer.parseInt(fontSize));
			styles.add(StyleFactory.createStyle(Integer.parseInt(level), new Color(Integer.parseInt(color, 16)), font, leading));
			
		}
		
		return new ConcreteTheme("theme1", styles);
	}

	public static Theme getPredefined(int optie) {
		List<Style> styles = new ArrayList<Style>();    
		// Hard coded styles
		String fname = "";
		switch (optie) {
			case 1: fname="Helvetica";break;
			case 2: fname="Times New Roman";break;		
			case 3: fname="Calibri";break;
		default:
			fname="Arial"; break;
		}
		
		styles.add(StyleFactory.createStyle(0, Color.red,  createFont(fname, Font.BOLD,  48), 20));
		styles.add(StyleFactory.createStyle(20, Color.blue,  createFont(fname, Font.BOLD,40), 10));
		styles.add(StyleFactory.createStyle(50, Color.black, createFont(fname, Font.BOLD,36), 10));
		styles.add(StyleFactory.createStyle(70, Color.black, createFont(fname, Font.BOLD,30), 10));
		styles.add(StyleFactory.createStyle(90, Color.black, createFont(fname, Font.BOLD,24), 10));
		
		return new ConcreteTheme("theme1", styles);
		
	}
	
	
}
