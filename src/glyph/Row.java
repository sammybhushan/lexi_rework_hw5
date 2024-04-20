// OOP DESIGN PATTERNS:
// Composite
package glyph;
import compositor.Compositor;
import window.Window;
public class Row extends Composition{
    public Row(Compositor compositor) {
        super(compositor);
    }
    public Row(String characters, Compositor compositor,Window window){
        super(compositor);
        for(int i=0;i < characters.length(); i++){
            this.insert(new Character(characters.charAt(i),window),i);
        }
    }

    @Override
    public void setPosition(Bounds cursor) {
        // a column has started composition
        this.bounds.xS = cursor.xS;
        this.bounds.xE = cursor.xS;
        this.bounds.yS = cursor.yS;
        this.bounds.yE = cursor.yS;
    }

    @Override
    public void updateBounds(Bounds cursor, Bounds child) {
        // passing the current cursor, and the new bounds of the child
        if(child == null){
            // update cursor only
        }
        else {
            // if row got longer, update bounds
            if (this.bounds.xE < child.xE) {
                this.bounds.xE = child.xE;
            }
            // if col got taller, update bounds and cursor
            if (this.bounds.yE < child.yE) {
                this.bounds.yE = child.yE;
            }
            cursor.xS = this.bounds.xE; // row xs start moves right for next child, ys stays the same
        }
    }

    @Override
    public void draw(Window window){
        for(int i=0; i < this.numChild(); i++){
            this.getChild(i).draw(window);
        }
    }
    public Bounds applyBounds(Bounds cursor) {
        this.bounds.xS = cursor.xS;
        this.bounds.yS = cursor.yS;
        this.bounds.xE = cursor.xE; // cursor will send size of children
        this.bounds.yE = cursor.yE; // cursor will send size of children
        return cursor;
    }
    @Override
    public void setCursor(Bounds cursor) {
        // row is complete, update the cursor for the bounds
        cursor.xS = bounds.xS;
        cursor.yS = bounds.yS;
//        cursor.yE = bounds.yE;
//        cursor.xE = bounds.xS;
    }

}