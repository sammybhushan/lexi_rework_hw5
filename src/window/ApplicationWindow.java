package window;

import compositor.SimpleCompositor;
import glyph.Glyph;
import glyph.Character;
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
        keyMap.putCtrl('i',new IncrementFont(this));
        keyMap.putCtrl('d',new DecrementFont(this));
        keyMap.putCtrl('u',new Undo());
        keyMap.putCtrl('r',new Redo());

        keyMap.putCtrl('b',new Back(this));
        keyMap.putCtrl('f',new Forward(this));
        //TODO: write these
        keyMap.putCtrl('h',new Delete(this));
//        keyMap.putCtrl('z',new InsertRect());

        keyMap.putCtrl('x',new InsertRow(this,new SimpleCompositor()));
        keyMap.putCtrl('c',new InsertColumn(this,new SimpleCompositor()));
        keyMap.putCtrl('v',new InsertScroller(this,new SimpleCompositor()));

    }
}
