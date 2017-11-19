package nl.slompweij.jabberpoint.model;

/**
 * <p>
 * Represents an image item. 
 * The ImageDrawing class is responsible for the drawing.
 * </p>
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/18 Arend and Wilko
 */
public class ImageItem extends SlideItem {
	private String imageName;

	public ImageItem(int level, String imageName) {
		super(level);
		this.imageName = imageName;
	}

	public String getImageName() {
		return imageName;
	}

	public String toString() {
		return "ImageItem[" + getLevel() + "," + imageName + "]";
	}
}
