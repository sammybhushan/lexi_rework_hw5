
package glyph;
import iter.CreateIterator;
import iter.Iterator;
import command.*;
import iter.NullIter;
import window.*;


public abstract class Glyph implements CreateIterator {

    // Variables
    protected Glyph parent;
    public Bounds bounds;
    protected Command command;
    protected int index;

    // Implemented Funcs
    public Glyph getParent(){
        return this.parent;
    }
    void setParent(Glyph parent){
        this.parent = parent;
    }
    public Glyph(){
        command = new Move(this);
//        command = new ParentCount(this); // for testing
        index = -1; //so we know it was not inserted?
    }
    public Bounds getBounds(){
        return this.bounds;
    }

    // Abstract
    public abstract void draw(Window window);
    public abstract void insert(Glyph newGlyph,int index);
    public abstract int remove(Glyph glyph);
    public abstract void startCompose();
    public abstract void compose();
    public abstract Glyph getChild(int index);
    public abstract void setPosition(Bounds cursor);
    public abstract void setSize();
    public abstract void setCursor(Bounds cursor);
    public abstract void updateBounds(Bounds cursor,Bounds childBounds);

    public void setIndex(int idx){
        index = idx;
    }
    public int getIndex(){
        return index;
    }

    public Command click(){
//        if(parent == null){
//            return null;
//        }
        return command;
//        else{
//            return parent.click();
//        }
    }

    boolean inside(int x, int y){
        if(bounds == null){
            return false;
        }
        if(this.bounds.xS <= x && this.bounds.xE >= x){
            if(this.bounds.yS <= y && this.bounds.yE >= y){
                return true;
            }
        }
        return false;
    }
    public Glyph find(int x, int y) {
        if (inside(x, y)){
            return this;
        }
        return null;
    }

    public Iterator createIterator(){
        return new NullIter();
    }
}
