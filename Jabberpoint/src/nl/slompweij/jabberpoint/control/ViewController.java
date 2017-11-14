package nl.slompweij.jabberpoint.control;

import nl.slompweij.jabberpoint.view.SlideViewerFrame;

public class ViewController {
	private SlideViewerFrame frame = null;
	public ViewController(SlideViewerFrame frame) {
		this.frame = frame;
	}
	public void updateView() {
		frame.update();
	}
}
