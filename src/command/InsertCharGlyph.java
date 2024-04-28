package command;

import glyph.Character;
import glyph.Glyph;
import window.*;
public class InsertCharGlyph implements Command{
    Window window;
    Glyph glyph;
    Glyph prevGlyph;
    char character;
    public InsertCharGlyph(Window w, char c){
        window = w;
        character = c;
        glyph = new Character(c, w);
    }
    public InsertCharGlyph(Window w, char c,Glyph prev){
        window = w;
        character = c;
        glyph = new Character(c, w);
        prevGlyph = prev;
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public void execute() {
        prevGlyph = InsertPoint.getInsertPoint().getGlyph();
        InsertPoint.getInsertPoint().insertGlyph(glyph);
        this.window.repaint();
    }

    @Override
    public void unexecute() {
        Glyph parent = glyph.getParent();
        parent.remove(glyph);
        InsertPoint.getInsertPoint().setCursor(prevGlyph);
        this.window.repaint();
    }

    @Override
    public Command clone(){
        return new InsertCharGlyph(window, character, prevGlyph);
    }

}
