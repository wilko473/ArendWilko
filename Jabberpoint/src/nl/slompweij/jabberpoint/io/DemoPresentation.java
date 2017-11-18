package nl.slompweij.jabberpoint.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.slompweij.jabberpoint.factory.SlideFactory;
import nl.slompweij.jabberpoint.factory.SlideItemFactory;
import nl.slompweij.jabberpoint.model.ConcretePresentation;
import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Slide;
import nl.slompweij.jabberpoint.model.SlideItem;

/** Een ingebouwde demo-presentatie
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2017/11/13 Arend and Wilko
 */

public class DemoPresentation extends Accessor {

	@Override
	public Presentation loadPresentation(String fn) throws IOException {
		

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

	@Override
	public void saveFile(Presentation p, String fn) throws IOException {

		throw new IOException("Demo presentatie kan niet worden opgeslagen");
		 
	}
	
}
