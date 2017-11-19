package nl.slompweij.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import nl.slompweij.jabberpoint.model.Style;

public interface ItemDrawing {
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);
	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer);
}
