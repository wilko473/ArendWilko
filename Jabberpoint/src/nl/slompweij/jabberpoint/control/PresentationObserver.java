package nl.slompweij.jabberpoint.control;

import nl.slompweij.jabberpoint.model.Presentation;

/**
 * Interface to observe a presentation object.
 * Decouples the dependency from control to view.
 * @author Arend and Wilko
 */
public interface PresentationObserver {
	void observe(Presentation presentation);
}
