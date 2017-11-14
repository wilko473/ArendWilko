package nl.slompweij.jabberpoint.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.JComponent;
import javax.swing.JFrame;

import nl.slompweij.jabberpoint.control.PresentationController;
import nl.slompweij.jabberpoint.factory.SlideItemFactory;
import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Slide;
import nl.slompweij.jabberpoint.model.SlideItem;
import nl.slompweij.jabberpoint.model.Style;


/** <p>SlideViewerComponent is een grafische component die Slides kan laten zien.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/13 Arend and Wilko
 */

public class SlideViewerComponent extends JComponent {
	
	private PresentationController presentationController = null;
	private Slide slide;
	private Font labelFont = null; // het font voor labels
	
	//private JFrame frame = null;
	
	private static final long serialVersionUID = 227L;
	
	public final static int PREFERRED_WIDTH = 1200;// TODO: afhankelijkheid weghalen en private maken
	private final static int PREFERRED_HEIGHT = 800;
	
	private static final Color BG_COLOR = Color.white;
	private static final Color SLIDENR_COLOR = Color.black;
	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	public SlideViewerComponent(PresentationController presentationController, JFrame frame) {
		this.presentationController = presentationController;
		//this.frame = frame;
		
		setBackground(BG_COLOR); 
		labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
	}

//	public void update(PresentationController presentationController, Slide data) {
//		if (data == null) {
//			repaint();
//			return;
//		}
//		this.presentationController = presentationController;
//		this.slide = data;
//		repaint();
//		frame.setTitle(presentationController.getPresentation().getTitle());
//	}

// teken de slide
	public void paintComponent(Graphics g) {
		g.setColor(BG_COLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);
//		if (presentation.getSlideNumber() < 0 || slide == null) {
//			return;
//		}
		g.setFont(labelFont);
		g.setColor(SLIDENR_COLOR);
		g.drawString("Slide " + (1 + presentationController.getCurrentSlide()) + " of " +
				presentationController.getPresentation().getSize(), XPOS, YPOS);
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		drawSlide(g, area, this);
	}
	
	private void drawSlide(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
		
		//Style style = Style.getStyle(slideItem.getLevel());// 
		Presentation presentation = presentationController.getPresentation();
		Style style = presentation.getTheme().getStyles().get(0);// TODO: method maken in presentation of theme?
		
		slide = presentation.getSlide(presentationController.getCurrentSlide());
		
		int y = area.y;
		
		// De titel wordt apart behandeld
		SlideItem slideItemTitle = SlideItemFactory.createTextItem(0, slide.getTitle());// TODO: betere oplossing?
		slideItemTitle.draw(area.x, y, scale, g, style, view);
		y += slideItemTitle.getBoundingBox(g, view, scale, style).height;
		
		// TODO: Iterator Pattern?
		for (int number = 0; number < presentation.getSize(); number++) {
//			slideItem = (SlideItem) getSlideItems().elementAt(number);
//			style = Style.getStyle(slideItem.getLevel());
//			slideItem.draw(area.x, y, scale, g, style, view);
//			y += slideItem.getBoundingBox(g, view, scale, style).height;
			
			SlideItem slideItem = slide.getSlideItems().get(number);
			Style itemStyle = presentation.getTheme().getStyles().get(slideItem.getLevel());
			slideItem.draw(area.x, y, scale, g, itemStyle, view);
			y += slideItem.getBoundingBox(g, view, scale, itemStyle).height;
		}
	}

	/**
	 * Calculates the scale to draw the slide.
	 * @param area
	 * @return
	 */
	private float getScale(Rectangle area) {
		return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
	}
}
