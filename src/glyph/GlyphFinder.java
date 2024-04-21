// OOP DESIGN PATTERNS:
// Composite

package glyph;
import glyph.*;
public class GlyphFinder{

    private Composition composition;
    //Bounds cursor;
    public void setComposition(Composition compositionGlyph) {
        this.composition = compositionGlyph;
    }


    public Glyph find(int x, int y) {
        if(!this.composition.inside(x, y)) {
            System.out.println("Click outside of glyphs");
            return null;
        }
        for(int i=0; i < this.composition.numChild(); i++) {
            // ask child to set size based on window
            if (this.composition.getChild(i).inside(x,y)){
                return this.composition.getChild(i).find(x,y);
            }
        }
        return null;
    }

        /*

        cursor.set(this.composition.getBounds()); // this cursor is now at the starting point of this composition
        this.composition.setPosition(cursor); // if this composition has a size (like border), it will adjust accordingly
        for(int i=0; i < this.composition.numChild(); i++) {
            this.composition.getChild(i).setPosition(cursor);
            this.composition.getChild(i).compose(); //composed now
            //this.cursor.xS
        }
        this.composition.setCursor(cursor); // if this composition has a size (like border), it will adjust accordingly





        cursor.print(); // cursor has been updated as row is finished composing
        // This compose method works through the recursion of composing the tree
        // the 'compose' method in the Glyph serves as a way to call this one from the root glyph
        // 'up up up up root > simple.compose() > tree traversal of compositions
        // create cursor based on parent
        cursor.set(this.composition.getBounds()); // 0 0 0 0 at start
        this.composition.setCursor(cursor); //update the cursor for this
        for(int i=0; i < this.composition.numChild(); i++){
            this.composition.getChild(i).setPosition(cursor); // child sets position & size (single cursor
            this.composition.getChild(i).compose(); // child composes - call the compositor (simple) on the child DIRECTLY

            // set the size here based on that composition


            if (composition.getChild(i).getBounds().yE > cursor.yE){
                cursor.yE = composition.getChild(i).getBounds().yE;
            }
            cursor.print(); // cursor has been updated as row is finished composing
        }
        composition.setPosition(cursor); //the whole size of the composition
        composition.setCursor(cursor);
        // set final size based on cursor
//        cursor.xS = cursor.xS
//        cursor.yS = cursor.yE

        // create cursor based on parent
        //for (... child= ...) {
            // ask (leaf) child to set size, based on window
            // ask child to set position, based on cursor
            // ask child to compose itself, recursively
            // ask parent to adjust itself and cursor, based on child
    }
        // ask parent to adjust itself, based on cursor

         */
}
