package nl.slompweij.jabberpoint.factory;

import java.awt.Color;
import java.awt.Font;

import nl.slompweij.jabberpoint.model.ConcreteStyle;
import nl.slompweij.jabberpoint.model.Style;

public class StyleFactory {
	public static Style createStyle(int indent, Color color,Font font, int leading) {
		return new ConcreteStyle(indent, color, font, leading);
	}
}
