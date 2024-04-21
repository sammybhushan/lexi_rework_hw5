
package glyph;
import command.Command;
import window.*;


public abstract class Glyph {

    // Variables
    protected Glyph parent;
    public Bounds bounds;

    // Implemented Funcs
    public Glyph getParent(){
        return this.parent;
    }
    void setParent(Glyph parent){
        this.parent = parent;
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

    public Command click(){
        if(parent == null){
            return null;
        }
        else{
            return parent.click();
        }
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
}
