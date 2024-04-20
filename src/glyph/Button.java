// Concrete Object from Factory
package glyph;
import compositor.Compositor;
import window.Window;
public class Button extends Embellishment {
    String color;

    public Button(Compositor compositor, String lookFeel) {
        super(compositor);
        color = lookFeel;

    }

    @Override
    public void setPosition(Bounds cursor) {

        // set start bounds
        this.bounds.xS = cursor.xS;
        this.bounds.yS = cursor.yS;

        // ask child to set position
//        this.getChild(0).setPosition(cursor);

        // x
        this.bounds.xE = cursor.xS;
        cursor.xS = this.bounds.xS;
        // y
        this.bounds.yE = cursor.yS;
        cursor.yS = this.bounds.yS;
    }

    public void updateBounds(Bounds cursor, Bounds child) {
        if(child == null){
           // update bounds
        }
        else {
            // passing the current cursor, and the new bounds of the child

            // if row got longer, update bounds and cursor
            if (this.bounds.xE < child.xE) {
                this.bounds.xE = child.xE;
                cursor.xS = child.xE;
            }
            // if row got taller, update bounds but keep cursor the same
            if (this.bounds.yE < child.yE) {
                this.bounds.yE = child.yE;
            }
//            this.getChild(0).setPosition(cursor);
        }
    }

    @Override
    public void setCursor(Bounds cursor) {
        // row is complete, update the cursor for the bounds
        bounds.yE = cursor.yE;
        bounds.xE = cursor.xE;
        cursor.xS = bounds.xS;
        cursor.yS = bounds.yE;
    }
    @Override
    public void draw(Window window) {

        window.drawButton(this.bounds.xS, this.bounds.yS, this.bounds.xE, this.bounds.yE, this.color);
        this.getChild(0).draw(window);
    }
}
