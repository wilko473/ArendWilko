package nl.slompweij.jabberpoint.model;

import java.awt.Color;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a theme. 
 */
public abstract class Theme {
	private String name = null;
	private Color backgroundColour = Color.WHITE;
	private List<Style> styles = new ArrayList<Style>();
	private HashMap<Integer, Theme> specificThemesForSlides = new HashMap<Integer, Theme>();
	private List<SlideItem> defaultItems = new ArrayList<SlideItem>();
	private int appliesTo;
	
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

	public int getAppliesTo()
	{
		return appliesTo;
	}
	
	
	public Color getBackgroundColour() {
		return backgroundColour;
	}

	public Theme getThemeForSlide(int slidenumber)
	{
		
		return specificThemesForSlides.getOrDefault(slidenumber, this);			
		
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

	public void setSlideThemeForSlides(HashMap<Integer, Theme> slideTheme) {
		this.specificThemesForSlides = slideTheme;
		
	}
}
