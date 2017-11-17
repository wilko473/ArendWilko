package nl.slompweij.jabberpoint.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.slompweij.jabberpoint.io.Accessor;
import nl.slompweij.jabberpoint.io.XMLAccessor;
import nl.slompweij.jabberpoint.model.ConcretePresentation;
import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Slide;
import nl.slompweij.jabberpoint.model.SlideItem;
import nl.slompweij.jabberpoint.model.Theme;

public class PresentationFactory {
	
	public static Presentation createPresentation(String[] parameters) throws IOException {
		Presentation result = null;
		if (parameters == null || parameters.length == 0) {
			result = createDemoPresentation();
		} else {
			Accessor accessor = new XMLAccessor();
			
			result = accessor.loadFile(parameters[0]);
			
		}
		return result;
	}
	
	private static Presentation createDemoPresentation() {

		List<Slide> slides = new ArrayList<Slide>();
		
		List<SlideItem> slideItems0 = new ArrayList<SlideItem>();
		slideItems0.add(SlideItemFactory.createTextItem(1, "Het Java Presentatie Tool"));
		slideItems0.add(SlideItemFactory.createTextItem(2, "Copyright (c) 1996-2000: Ian Darwin"));
		slideItems0.add(SlideItemFactory.createTextItem(2, "Copyright (c) 2000-now:"));
		slideItems0.add(SlideItemFactory.createTextItem(2, "Gert Florijn en Sylvia Stuurman"));
		slideItems0.add(SlideItemFactory.createTextItem(4, "JabberPoint aanroepen zonder bestandsnaam"));
		slideItems0.add(SlideItemFactory.createTextItem(4, "laat deze presentatie zien"));
		slideItems0.add(SlideItemFactory.createTextItem(1, "Navigeren:"));
		slideItems0.add(SlideItemFactory.createTextItem(3, "Volgende slide: PgDn of Enter"));
		slideItems0.add(SlideItemFactory.createTextItem(3, "Vorige slide: PgUp of up-arrow"));
		slideItems0.add(SlideItemFactory.createTextItem(3, "Stoppen: q or Q"));
		slides.add(SlideFactory.createSlide("JabberPoint", slideItems0));

		List<SlideItem> slideItems1 = new ArrayList<SlideItem>();
		slideItems1.add(SlideItemFactory.createTextItem(1, "Level 1"));
		slideItems1.add(SlideItemFactory.createTextItem(2, "Level 2"));
		slideItems1.add(SlideItemFactory.createTextItem(1, "Nogmaals level 1"));
		slideItems1.add(SlideItemFactory.createTextItem(1, "Level 1 heeft stijl nummer 1"));
		slideItems1.add(SlideItemFactory.createTextItem(2, "Level 2 heeft stijl nummer 2"));
		slideItems1.add(SlideItemFactory.createTextItem(3, "Zo ziet level 3 er uit"));
		slideItems1.add(SlideItemFactory.createTextItem(4, "En dit is level 4"));
		slides.add(SlideFactory.createSlide("Demonstratie van levels en stijlen", slideItems1));

		List<SlideItem> slideItems2 = new ArrayList<SlideItem>();
		slideItems2.add(SlideItemFactory.createTextItem(1, "Om een nieuwe presentatie te openen,"));
		slideItems2.add(SlideItemFactory.createTextItem(2, "gebruik File->Open uit het menu."));
		slideItems2.add(SlideItemFactory.createTextItem(1, " "));
		slideItems2.add(SlideItemFactory.createTextItem(1, "Dit is het einde van de presentatie."));
		slideItems2.add(SlideItemFactory.createBitmapItem(1, "JabberPoint.jpg"));
		slides.add(SlideFactory.createSlide("De derde slide", slideItems2));
		
		return new ConcretePresentation("Demo Presentation", slides);
	}
}
