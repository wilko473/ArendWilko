package nl.slompweij.jabberpoint.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a theme.
 */
public abstract class Theme {
	private String name = null;
	private List<Style> styles = new ArrayList<Style>();
	
	public Theme(String name, List<Style> styles) {
		if (name == null) {
			throw new IllegalArgumentException("Name is required");
		}
		if (styles == null) {
			throw new IllegalArgumentException("Styles is required");
		}
		this.name = name;
		this.styles = styles;
	}

	public String getName() {
		return name;
	}

	public List<Style> getStyles() {
		return styles;
	}
}
