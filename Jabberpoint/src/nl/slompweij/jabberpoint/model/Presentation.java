package nl.slompweij.jabberpoint.model;
import java.util.List;


/**
 * <p>Represents a presentation.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/13 Arend and Wilko
 */

public abstract class Presentation {
	private String title;
	private List<Slide> slides = null;
	private Theme theme = null;

	// TODO: geen currentSlideNumber!
	//private int currentSlideNumber = 0; // het slidenummer van de huidige Slide
	// TODO SlideViewerComponent moet verdwijnselen
	//private SlideViewerComponent slideViewComponent = null; // de viewcomponent voor de Slides

	public Presentation(String title, List<Slide> slides, Theme theme) {
//		slideViewComponent = null;
//		clear();
		if (title == null) {
			throw new IllegalArgumentException("Title is required");
		}
		if (slides == null) {
			throw new IllegalArgumentException("Slides is required");
		}
		if (theme == null) {
			throw new IllegalArgumentException("Theme is required");
		}
		this.title = title;
		this.slides = slides;
		this.theme = theme;
	}

	// TODO: drama
//	public Presentation(SlideViewerComponent slideViewerComponent) {
//		this.slideViewComponent = slideViewerComponent;
//		clear();
//	}

	public int getSize() {
		return slides.size();
	}

	public String getTitle() {
		return title;
	}
	
	public Theme getTheme() {
		return theme;
	}

//	public void setTitle(String nt) {
//		showTitle = nt;
//	}

	// TODO: Dit moet anders
//	public void setShowView(SlideViewerComponent slideViewerComponent) {
//		this.slideViewComponent = slideViewerComponent;
//	}

	// TODO: Remove!
	// geef het nummer van de huidige slide
//	public int getSlideNumber() {
//		return currentSlideNumber;
//	}

	// TODO: Remove!
	// verander het huidige-slide-nummer en laat het aan het window weten.
//	public void setSlideNumber(int number) {
//		currentSlideNumber = number;
//		if (slideViewComponent != null) {
//			slideViewComponent.update(this, getCurrentSlide());
//		}
//	}

	// TODO: Remove!
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
//	public void prevSlide() {
//		if (currentSlideNumber > 0) {
//			setSlideNumber(currentSlideNumber - 1);
//	    }
//	}

	// TODO: Remove!
	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
//	public void nextSlide() {
//		if (currentSlideNumber < (showList.size()-1)) {
//			setSlideNumber(currentSlideNumber + 1);
//		}
//	}

	// TODO: Er wordt een nieuwe presentatie gemaakt door juiste factory; deze instantie is overbodig en clear zal dus NOOIT gebruikt MOGEN worden	
	// Verwijder de presentatie, om klaar te zijn voor de volgende
//	void clear() {
//		showList = new ArrayList<Slide>();
//		setSlideNumber(-1);
//	}

	// TODO: Dit moet gebeuren dmv een factory REWORK
	// Voeg een slide toe aan de presentatie
//	public void append(Slide slide) {
//		showList.add(slide);
//	}

	/**
	 * Returns the slide at specified index.
	 * Throws IndexOutOfBoundsException if the index is invalid.
	 * @param index
	 * @return The Slide at index
	 * @throws IndexOutOfBoundsException if there is no slide with specified index (runtime exception)
	 */
	public Slide getSlide(int index) {
		return slides.get(index);
	}

	// TODO: Verwijder dit; een presentatie weet niet waar die zelf is; conceptueel is dit onjuist (Presentatie bevat daadwerkelijk de informatie die 
	// getoont moet worden met informatie die hiervoor relevant is)
	// Geef de huidige Slide
//	public Slide getCurrentSlide() {
//		return getSlide(currentSlideNumber);
//	}

	// TODO: Exit???
//	public void exit(int n) {
//		System.exit(n);
//	}
}
