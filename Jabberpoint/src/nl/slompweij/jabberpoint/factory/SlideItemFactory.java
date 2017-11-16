package nl.slompweij.jabberpoint.factory;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import nl.slompweij.jabberpoint.model.ImageItem;
import nl.slompweij.jabberpoint.model.SlideItem;
import nl.slompweij.jabberpoint.model.TextItem;

public class SlideItemFactory {
	
    private static final String LEVEL = "level";
    private static final String KIND = "kind";
    private static final String TEXT = "text";
    private static final String IMAGE = "image";
    
    private static final String UNKNOWNTYPE = "Unknown Element type";
    private static final String NFE = "Number Format Exception";
	
	public static SlideItem createSlideItem(Element item) {
		SlideItem result = null;
		
		int level = 1; // default
		NamedNodeMap attributes = item.getAttributes();
		String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
		if (leveltext != null) {
			try {
				level = Integer.parseInt(leveltext);
			}
			catch(NumberFormatException x) {
				System.err.println(NFE);
			}
		}
		String type = attributes.getNamedItem(KIND).getTextContent();
		if (TEXT.equals(type)) {
			result = new TextItem(level, item.getTextContent());
		}
		else {
			if (IMAGE.equals(type)) {
				result = new ImageItem(level, item.getTextContent());
			}
			else {
				System.err.println(UNKNOWNTYPE);
			}
		}
		return result;
	}
	
	public static SlideItem createTextItem(int level, String text) {
		return new TextItem(level, text);
	}
	
	public static SlideItem createBitmapItem(int level, String name) {
		return new ImageItem(level, name);
	}
}
