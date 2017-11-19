package nl.slompweij.jabberpoint.model;

import java.util.List;

public class SlideFactory {
	public static Slide createSlide(String title, List<SlideItem> slideItems) {
		return new ConcreteSlide(title, slideItems);
	}
}
