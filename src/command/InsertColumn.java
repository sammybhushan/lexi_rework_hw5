package command;

import glyph.*;
import compositor.*;
import window.*;

public class InsertColumn implements Command{
    Window window;
    Glyph glyph;
    Compositor compositor;
    public InsertColumn(Window w, Compositor c){
        window = w;
        compositor = c;
        glyph = new Column(c);
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public void execute() {
        // need to rewrite/add more once we have the insert point more realized
//        InsertPoint.getInsertPoint().insertGlyph(glyph);
    }

    @Override
    public void unexecute() {
        Glyph parent = glyph.getParent();
        parent.remove(glyph);
    }

    @Override
    public Command clone(){
        return new InsertColumn(window, compositor);
    }

}
