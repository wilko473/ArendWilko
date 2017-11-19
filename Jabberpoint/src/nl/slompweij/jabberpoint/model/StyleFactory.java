package nl.slompweij.jabberpoint.model;

import java.awt.Color;
import java.awt.Font;

public class StyleFactory {
	public static Style createStyle(int indent, Color color,Font font, int leading) {
		return new ConcreteStyle(indent, color, font, leading);
	}
}
