// command pattern
// prototype
// Moves the insertion point to the glyph that was clicked
package command;

import glyph.Glyph;
import window.InsertPoint;

public class Move implements Command{
    Glyph clickedGlyph;

    public Move(Glyph glyph){
        clickedGlyph = glyph;
    }

    @Override
    public void execute() {
        InsertPoint.getInsertPoint().move(clickedGlyph);
    }

    @Override
    public void unexecute() {

    }

    @Override
    public boolean undoable() {
        return false;
    }

    @Override
    public Command clone() {
        return this;
    }
}
