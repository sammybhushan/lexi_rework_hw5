package window;

import glyph.Glyph;
import command.*;

public class ApplicationWindow extends Window{
    String title;

    public ApplicationWindow(String title, Glyph startGlyph) {
        super(title);
        this.title = title;
        this.mainGlyph = startGlyph;
        setShortcuts();
    }
    void setShortcuts(){
        // application window shortcuts
        keyMap.put('i',new IncrementFont(this));
        keyMap.put('d',new DecrementFont(this));
//        keyMap.put('u',new Undo());
//        keyMap.put('r',new Redo());

    }
}
