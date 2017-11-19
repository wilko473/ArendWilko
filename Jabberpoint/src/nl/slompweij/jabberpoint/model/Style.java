package nl.slompweij.jabberpoint.model;
import java.awt.Color;
import java.awt.Font;

/** <p>Style staat voor Indent, Color, Font and Leading.</p>
 * 
 * De koppeling tussen style-nummer en item-level is nu direct:
 * in Slide wordt de style opgehaald voor een item
 * met als style-nummer het item-level.
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class Style {
	
	private int indent;
	private Font font;
	private Color fontColor;
	private int fontSize;
	private int leading;
	

	public Style(int indent, Color fontColor, Font font, int leading) {
		this.indent = indent;
		this.font = font;
		this.fontSize = font.getSize();
		this.fontColor = fontColor;
		this.leading = leading;
	}

	public String toString() {
		return "["+ indent + "," + fontColor + "; " + fontSize + " on " + leading +"]";
	}

	public int getIndent() {
		return indent;
	}

	public Font getFont() {
		return font;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public int getFontSize() {
		return font.getSize();
	}

	public int getLeading() {
		return leading;
	}

	public Font getFont(float scale) {
		return font.deriveFont(fontSize * scale);
	}
}
