package nl.slompweij.jabberpoint.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a theme. 
 */
public abstract class Theme {
	private String name = null;
	private Color backgroundColour = Color.WHITE;
	private List<Style> styles = new ArrayList<Style>();
	 
	private List<SlideItem> defaultItems = new ArrayList<SlideItem>();
	
	public Theme(String name, List<Style> styles, List<SlideItem> defaultItems) {
		if (name == null) {
			throw new IllegalArgumentException("Name is required");
		}
		if (styles == null) {
			throw new IllegalArgumentException("Styles is required");
		}
		
		this.defaultItems = defaultItems;
		this.name = name;
		this.styles = styles;
	}

	public String getName() {
		return name;
	}

	public Color getBackgroundColour() {
		return backgroundColour;
	}

	public List<SlideItem> getThemeSlideItems() {
		return defaultItems;
	}
	
	public void setBackgroundColour(Color backgroundColour) {
		if (backgroundColour == null) {
			throw new IllegalArgumentException("Invalid background colour!");
		}
		this.backgroundColour = backgroundColour;
	}

	/**
	 * Returns the style for a level. 
	 * @param level
	 * @return The style
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public Style getStyle(int level) {
		return styles.get(level);
	}

	public List<Style> getStyles() {
		
		return styles;
	}
}
