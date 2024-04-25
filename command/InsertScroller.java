package command;

import glyph.*;
import compositor.*;
import window.*;

public class InsertScroller implements Command{
    Window window;
    Glyph glyph;
    int width;
    Compositor compositor;
    public InsertScroller(Window w, Compositor c){
        window = w;
        compositor = c;
        width = 3;
        glyph = new Scroller(c,width);
    }

    public InsertScroller(Window w, Compositor c, int n){
        window = w;
        compositor = c;
        width = n;
        glyph = new Scroller(c,width);
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public void execute() {
        InsertPoint.getInsertPoint().insertGlyph(glyph);
    }

    @Override
    public void unexecute() {
        Glyph parent = glyph.getParent();
        parent.remove(glyph);
    }

    @Override
    public Command clone(){
        return new InsertScroller(window, compositor, width);
    }

}
