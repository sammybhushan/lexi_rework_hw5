// command pattern
// prototype
package command;

import glyph.Character;
import glyph.Glyph;
import window.*;
public class Delete implements Command{
    Window window;
    Glyph deletedGlyph; //removed glyph
    char character;
    public Delete(Window w){
        window = w;
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public void execute() {
        deletedGlyph = InsertPoint.getInsertPoint().removeGlyph();
//        InsertPoint.getInsertPoint().removeCursor();
        this.window.repaint();
    }

    @Override
    public void unexecute() {
        deletedGlyph.getParent().insert(deletedGlyph,deletedGlyph.getIndex());
        this.window.repaint();
    }

    @Override
    public Command clone(){
        Delete duplicate =  new Delete(window);
        duplicate.deletedGlyph = deletedGlyph;
        return duplicate;

    }

}
