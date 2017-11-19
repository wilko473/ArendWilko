package nl.slompweij.jabberpoint.view;

import nl.slompweij.jabberpoint.model.ImageItem;
import nl.slompweij.jabberpoint.model.SlideItem;
import nl.slompweij.jabberpoint.model.TextItem;

public class ItemDrawingFactory {
  public static ItemDrawing getItemDrawing(SlideItem slideItem) {
    if (slideItem instanceof TextItem) {
      return new TextDrawing(((TextItem) slideItem).getText());
    } else if (slideItem instanceof ImageItem) {
      return new ImageDrawing(((ImageItem) slideItem).getImageName());
    }
    return null;
  }
}
