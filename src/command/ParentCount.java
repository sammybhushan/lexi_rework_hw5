package command;

import glyph.Glyph;
import iter.*;

public class ParentCount implements Command{

    Glyph glyph;

    public ParentCount(Glyph clickedGlyph){
        glyph = clickedGlyph;
    }
    @Override
    public void execute() {
        Iterator iter = glyph.getParent().createIterator();
        int count=0;
        for(iter.first();!iter.done();iter.next()){
            if(iter.current() != null)
                count++;
        }
        System.out.println(count);

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
