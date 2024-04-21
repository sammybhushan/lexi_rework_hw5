package window;

import glyph.Glyph;
import command.*;

public class ApplicationWindow extends Window{
    String title;
    CommandHistory history;

    public ApplicationWindow(String title, Glyph startGlyph,CommandHistory history) {
        super(title);
        this.title = title;
        this.mainGlyph = startGlyph;
        this.history = history;
        setShortcuts();
    }
    void setShortcuts(){
        // application window shortcuts
        keyMap.put('i',new IncrementFont(this));
        keyMap.put('d',new DecrementFont(this));
        keyMap.put('u',new Undo());
        keyMap.put('r',new Redo());

//        keyMap.put('t',new FontSizeTwenty(this)); //debug
//        keyMap.put('f',new FontSizeFourteen(this)); //debug

    }
}
