// OOP DESIGN PATTERNS:
// Decorator
// Composite
package glyph;

import window.Window;
import compositor.Compositor;
public class Scroller extends Embellishment{

    int width;
    int height;
    public Scroller(Compositor compositor,int width) {
        super(compositor);
        this.width = width;
    }
    public void draw(Window window) {
        window.addScrollBar(bounds.xE-width, bounds.yS, width, bounds.yE-bounds.yS);
        this.children.get(0).draw(window);
    }

    public void setPosition(Bounds cursor) {

        // set start bounds
        this.bounds.xS = cursor.xS;
        this.bounds.yS = cursor.yS;

        // cursor does not get altered
        this.bounds.xE = cursor.xS + this.width;
        this.bounds.yE = cursor.yS;
//        cursor.yS = this.bounds.yS + this.width;
    }

    @Override
    public void updateBounds(Bounds cursor, Bounds child) {
        // passing the current cursor, and the new bounds of the child
        if(child == null){
            // update bounds only
        }
        else {
            this.bounds.xE = child.xE + this.width;
            // if row got longer, update bounds and cursor
            if (this.bounds.xE < this.bounds.xE + child.xE) {
                this.bounds.xE = child.xE + this.width;
                cursor.xS = child.xE;
            }
            // if row got taller, update bounds but keep cursor the same
            if (this.bounds.yE < child.yE) {
                this.bounds.yE = child.yE;
            }
            //this.getChild(0).setPosition(cursor);
        }
    }

    @Override
    public void setCursor(Bounds cursor) {
        // updating bounds for children
        // for a border, we will move by 1x width and height
        cursor.xS = this.bounds.xS;
        cursor.yS = this.bounds.yS;

    }
}