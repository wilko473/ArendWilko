package nl.slompweij.jabberpoint.factory;

import java.util.List;

import nl.slompweij.jabberpoint.model.ConcreteSlide;
import nl.slompweij.jabberpoint.model.Slide;
import nl.slompweij.jabberpoint.model.SlideItem;

public class SlideFactory {
	public static Slide createSlide(String title, List<SlideItem> slideItems) {
		return new ConcreteSlide(title, slideItems);
	}
}
