package nl.slompweij.jabberpoint.view;

import java.util.ListResourceBundle;
import java.util.Locale;

public abstract class LabelsBundle extends ListResourceBundle {
	public static final Locale SUPPORTED_LOCALES_en_US = new Locale("en", "US");

	public static enum Label {
		ABOUT, FILE, EXIT, GOTO, HELP, NEW, NEXT, OPEN, PAGENR, PREV, SAVE, VIEW
	}
}
