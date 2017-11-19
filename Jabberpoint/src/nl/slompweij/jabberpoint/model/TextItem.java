package nl.slompweij.jabberpoint.model;

/**
 * <p>
 * Represents a text item. 
 * The TextDrawing class is responsible for the drawing.
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
public class TextItem extends SlideItem {
	private String text = null;

	public TextItem(int level, String text) {
		super(level);
		if (text == null) {
			this.text = "";
		} else {
			this.text = text;
		}
	}

	public String getText() {
		return text;
	}

	public String toString() {
		return "TextItem[" + getLevel() + "," + getText() + "]";
	}
}
