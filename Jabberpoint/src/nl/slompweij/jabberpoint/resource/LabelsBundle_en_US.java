package nl.slompweij.jabberpoint.resource;

/**
 * Resourcebundle class to contain the labels of the application.
 */
public class LabelsBundle_en_US extends LabelsBundle {
	
	private Object[][] contents = {
	    { Label.ABOUT.name(), "About" },
	    { Label.FILE.name(), "File" },
	    	{ Label.EXIT.name(), "Exit"},
	    	{ Label.GOTO.name(), "Goto"},
	    	{ Label.HELP.name(), "Help"},
	    	{ Label.NEW.name(), "New"},
	    	{ Label.NEXT.name(), "Next"},
	    	{ Label.OPEN.name(), "Open"},
	    	{ Label.PAGENR.name(), "Page number?"},
	    	{ Label.PREV.name(), "Prev"},
	    	{ Label.SAVE.name(), "Save"},
	    	{ Label.VIEW.name(), "View"},
	    };
	
	@Override
	protected Object[][] getContents() {
		return this.contents;
	}
	
}
