package nl.slompweij.jabberpoint.model;
import java.util.List;
import java.util.Observable;


/**
 * Represents a presentation. 
 * This model class holds typical presentation properties such as title, theme and slides and is is also responsible for stepping through the slides.
 * Changes are notified to registered observers. 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/13 Arend and Wilko
 */

public abstract class Presentation extends Observable {
	private String title = null;
	private List<Slide> slides = null;
	private Theme theme = null;
	private int currentSlideNumber = 0;

	public Presentation(String title, List<Slide> slides) {
		if (title == null) {
			throw new IllegalArgumentException("Title is required");
		}
		if (slides == null) {
			throw new IllegalArgumentException("Slides is required");
		}
		/*if (theme == null) {
			throw new IllegalArgumentException("Theme is required");
		}*/
		
		this.title = title;
		this.slides = slides;
		//this.theme = theme;
	}

	public int getNumberOfSlides() {
		return slides.size();
	}

	public String getTitle() {
		return title;
	}
	
	public Theme getTheme() {
		return theme;	
	}
	
	public void setTheme(Theme theme) {
		this.theme = theme;
		setChanged();
		notifyObservers();
	}

	public Slide getCurrentSlide() {
		return slides.get(currentSlideNumber);
	}
	
	public void nextSlide() {
		if (currentSlideNumber < slides.size() - 1) {
			currentSlideNumber++;
			setChanged();
			notifyObservers();
		}
	}

	public void previousSlide() {
		if (currentSlideNumber > 0) {
			currentSlideNumber--;
			setChanged();
			notifyObservers();
		}
	}

	public int getCurrentSlideNumber() {
		return currentSlideNumber;
	}
	
	public void setCurrentSlideNumber(int newSlideNumber) {
		if (newSlideNumber > -1 && newSlideNumber < slides.size() - 1) {
			this.currentSlideNumber = newSlideNumber;
			setChanged();
			notifyObservers();
		}
	}

	public List<Slide> getSlides() {
		return slides;
	}

}
