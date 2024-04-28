// command pattern
// prototype
package command;

import glyph.*;
import compositor.*;
import window.*;

public class InsertRow implements Command{
    Window window;
    Glyph glyph;
    Compositor compositor;
    public InsertRow(Window w, Compositor c){
        window = w;
        compositor = c;
        glyph = new Row(c);
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public void execute() {
//        InsertPoint.getInsertPoint().insertGlyph(glyph);
    }

    @Override
    public void unexecute() {
        Glyph parent = glyph.getParent();
        parent.remove(glyph);
    }

    @Override
    public Command clone(){
        return new InsertRow(window, compositor);
    }

}
