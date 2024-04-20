package window;

import glyph.Glyph;

public class ApplicationWindow extends Window{
    String title;

    public ApplicationWindow(String title, Glyph startGlyph) {
        super(title);
        this.title = title;
        this.mainGlyph = startGlyph;
    }
}
