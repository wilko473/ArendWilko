package nl.slompweij.jabberpoint.io;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import nl.slompweij.jabberpoint.model.ConcretePresentation;
import nl.slompweij.jabberpoint.model.ImageItem;
import nl.slompweij.jabberpoint.model.Presentation;
import nl.slompweij.jabberpoint.model.Slide;
import nl.slompweij.jabberpoint.model.SlideFactory;
import nl.slompweij.jabberpoint.model.SlideItem;
import nl.slompweij.jabberpoint.model.SlideItemFactory;
import nl.slompweij.jabberpoint.model.Style;
import nl.slompweij.jabberpoint.model.TextItem;
import nl.slompweij.jabberpoint.model.Theme;
import nl.slompweij.jabberpoint.model.ThemeFactory;


/** XMLAccessor, reads and writes XML files
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class XMLAccessor extends Accessor {
	
    /** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** namen van xml tags of attributen */
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    protected static final String THEME = "theme";
    protected static final String TITEL = "titel";
    
    /** tekst van messages */
    protected static final String PCE = "Parser Configuration Exception";

    
    
    private String getTitle(Element element, String tagName) {
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();
    	
    }

	@Override
	
    
	public Presentation loadPresentation(String[] parameters) throws IOException {
		int slideNumber, itemNumber, maxItems = 0;
		String filename = parameters[0];
		Presentation result=null;
		try {
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
			Document document = builder.parse(new File(filename)); // maak een JDOM document
			Element doc = document.getDocumentElement();
			List<Slide> slides = new ArrayList<Slide>();
			
			NodeList slideNodes = doc.getElementsByTagName(SLIDE);
			for (slideNumber = 0; slideNumber < slideNodes.getLength(); slideNumber++) {
				Element xmlSlide = (Element) slideNodes.item(slideNumber);
				
				String slideTitle = getTitle(xmlSlide, SLIDETITLE);
				
				
				List<SlideItem> slideItems = new ArrayList<SlideItem>();
				
				NodeList slideItemNodes = xmlSlide.getElementsByTagName(ITEM);
				maxItems = slideItemNodes.getLength();
				for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
					Element item = (Element) slideItemNodes.item(itemNumber);
					//loadSlideItem(slide, item);
					SlideItem slideItem = SlideItemFactory.createSlideItem(item);
					slideItems.add(slideItem);
				}
				
				Slide slide = SlideFactory.createSlide(slideTitle, slideItems);
				slides.add(slide);
			}		
	
						
			result=  new ConcretePresentation("titel", slides);
			
			NodeList theme = doc.getElementsByTagName(THEME);
			
			if (theme.getLength() > 0) {
				Element themeElement = (Element)doc.getElementsByTagName(THEME).item(0);
				
				Theme t = ThemeFactory.createTheme(themeElement);
				
				result.setTheme(t);
			}			
		} 
		catch (IOException iox) {
			System.err.println(iox.toString());
		}
		catch (SAXException sax) {
			System.err.println(sax.getMessage());
		}
		catch (ParserConfigurationException pcx) {
			System.err.println(PCE);
		}	
		return result;
	}

	public void saveFile(Presentation presentation, String filename) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
		out.println("<presentation>");
		out.print("<showtitle>");
		out.print(presentation.getTitle());
		out.println("</showtitle>");
		for (Slide slide : presentation.getSlides()) {
			out.println("<slide>");
			out.println("<title>" + slide.getTitle() + "</title>");
			List<SlideItem> slideItems = slide.getSlideItems();
			for (int itemNumber = 0; itemNumber<slideItems.size(); itemNumber++) {
				SlideItem slideItem = (SlideItem) slideItems.get(itemNumber);
				out.print("<item kind="); 
				if (slideItem instanceof TextItem) {
					out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
					out.print( ( (TextItem) slideItem).getText());
				}
				else {
					if (slideItem instanceof ImageItem) {
						out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
						out.print( ( (ImageItem) slideItem).getImageName());
					}
					else {
						System.out.println("Ignoring " + slideItem);
					}
				}
				out.println("</item>");
			}
			out.println("</slide>");
		}
		out.println("<theme>");
		out.println("<styles>");
		int teller = 0;
		for (Style c : presentation.getTheme().getStyles())
		{
			out.println("<style level="+teller+" color="+c.getFontColor()+" font-face='"+c.getFont().getFontName()+"' font-size="+c.getFontSize()+"/>");
		}
		out.println("</styles>");
		out.println("</theme");
		out.println("</presentation>");
		out.close();
	}


}
