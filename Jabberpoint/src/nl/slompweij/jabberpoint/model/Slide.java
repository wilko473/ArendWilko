package nl.slompweij.jabberpoint.model;

import java.util.List;

/**
 * <p>
 * Represents a slide. Has a title and contains slide items.
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

public abstract class Slide {	
	//private String title;TODO: Remove?
	private List<SlideItem> slideItems = null;

	public Slide(String title, List<SlideItem> slideItems) {
		if (title == null) {
			throw new IllegalArgumentException("Title is required");
		}
		if (slideItems == null) {
			throw new IllegalArgumentException("Slideitems are required");
		}
		//this.title = title;
		this.slideItems = slideItems;
	}

	public String getTitle() {
		if (slideItems != null && !slideItems.isEmpty() && slideItems.get(0) instanceof TextItem) {
			return ((TextItem) slideItems.get(0)).getText();
		}
		throw new IllegalStateException("Title is not set. Should be first element.");
	}

	// verander de titel van de slide
	// public void setTitle(String newTitle) {
	// title = newTitle;
	// }

	// Maak een TextItem van String, en voeg het TextItem toe
	// public void append(int level, String message) {
	// append(new TextItem(level, message));
	// }

	// geef het betreffende SlideItem
	// public SlideItem getSlideItem(int number) {
	// return (SlideItem)items.elementAt(number);
	// }

	public List<SlideItem> getSlideItems() {
		return slideItems;
	}

	// geef de afmeting van de Slide
	// public int getSize() {
	// return items.size();
	// }
}
