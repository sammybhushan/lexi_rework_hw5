// Patterns:
// command
// uses iterator

package command;

import glyph.CompositeGlyph;
import glyph.Glyph;
import iter.*;

public class WordCount implements Command{

    Glyph glyph;
    int count;

    public WordCount(Glyph rootGlyph){
        glyph = rootGlyph;
    }
    @Override
    public void execute() {
        Iterator iter = new PreorderIterator(glyph);
        count=0;
        for(iter.first();!iter.done();iter.next()){
            if(iter.current() != null)
                count++;
        }
        System.out.println("Count :" + count);

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
