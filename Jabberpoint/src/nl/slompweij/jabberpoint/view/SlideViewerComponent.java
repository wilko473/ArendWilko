package nl.slompweij.jabberpoint.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Slide;
import nl.slompweij.jabberpoint.model.SlideItem;
import nl.slompweij.jabberpoint.model.SlideItemFactory;
import nl.slompweij.jabberpoint.model.Style;
import nl.slompweij.jabberpoint.model.Theme;

/**
 * <p>
 * SlideViewerComponent is the view component that shows the slides.
 * </p>
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/13 Arend and Wilko
 */

public class SlideViewerComponent extends JComponent implements Observer {
	private Presentation presentation = null;
	private Font labelFont = null;

	private static final long serialVersionUID = 227L;

	public final static int PREFERRED_WIDTH = 1200;
	public final static int PREFERRED_HEIGHT = 800;

	private static final Color SLIDENR_COLOR = Color.black;

	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	public SlideViewerComponent() {
		labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
	}

	public void paintComponent(Graphics g) {
		if (presentation == null) {
			// Nothing to paint
			return;
		}
		Theme theme = presentation.getThemeForCurrentSlide();
		Slide slide = presentation.getCurrentSlide();

		drawSlide(g, slide, theme);
	}

	private void drawSlide(Graphics g, Slide slide, Theme theme) {
		// Set background colour from theme
		g.setColor(theme.getBackgroundColour());
		g.fillRect(0, 0, getSize().width, getSize().height);

		// Draw slide number with hardcoded style. TODO: move to theme?
		g.setFont(labelFont);
		g.setColor(SLIDENR_COLOR);
		g.drawString("Slide " + (1 + presentation.getCurrentSlideNumber()) + " of " + presentation.getNumberOfSlides(),
				XPOS, YPOS);

		// Calculate some drawing properties
		Rectangle drawingArea = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		float scale = getScale(drawingArea);
		int y = drawingArea.y;

		if (theme.getThemeSlideItems() != null) {
			for (SlideItem themeSlideItem : theme.getThemeSlideItems()) {
				y = drawSlideItem(g, theme, drawingArea, scale, y, themeSlideItem);
			}
		}

		SlideItem slideItemTitle = SlideItemFactory.createTextItem(0, slide.getTitle());

		y += drawSlideItem(g, theme, drawingArea, scale, y, slideItemTitle);

		for (SlideItem slideItem : slide.getSlideItems()) {
			y = drawSlideItem(g, theme, drawingArea, scale, y, slideItem);
		}
	}

	private int drawSlideItem(Graphics g, Theme theme, Rectangle drawingArea, float scale, int y, SlideItem slideItem) {
		Style itemStyle = theme.getStyle(slideItem.getLevel());
		
		ItemDrawing itemDrawing = ItemDrawingFactory.getItemDrawing(slideItem);
		itemDrawing.draw(drawingArea.x, y, scale, g, itemStyle, this);
		y += itemDrawing.getBoundingBox(g, this, scale, itemStyle).height;
		return y;
	}

	private float getScale(Rectangle drawingArea) {
		return Math.min(((float) drawingArea.width) / ((float) PREFERRED_WIDTH),
				((float) drawingArea.height) / ((float) PREFERRED_HEIGHT));
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof Presentation) {
			this.presentation = (Presentation) observable;
			repaint();
		}
	}
}
