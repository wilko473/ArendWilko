package nl.slompweij.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nl.slompweij.jabberpoint.model.Style;

public class ImageDrawing implements ItemDrawing {

	private static final String FILE = "Bestand ";
	private static final String NOTFOUND = " niet gevonden";

	private BufferedImage bufferedImage;

	public ImageDrawing(String imageName) {
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND);
		}
	}

	@Override
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
		return new Rectangle((int) (style.getIndent() * scale), 0, (int) (bufferedImage.getWidth(observer) * scale),
				((int) (style.getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));

	}

	@Override
	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
		int width = x + (int) (myStyle.getIndent() * scale);
		int height = y + (int) (myStyle.getLeading() * scale);
		g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
				(int) (bufferedImage.getHeight(observer) * scale), observer);
	}
}
