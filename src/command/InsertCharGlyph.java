package command;

import glyph.Character;
import glyph.Glyph;
import window.*;
public class InsertCharGlyph implements Command{
    Window window;
    Glyph glyph;
    char character;
    public InsertCharGlyph(Window w, char c){
        window = w;
        character = c;
        glyph = new Character(c, w);
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
        return new InsertCharGlyph(window, character);
    }

}
