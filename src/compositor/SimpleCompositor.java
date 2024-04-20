// OOP DESIGN PATTERNS:
// Composite

package compositor;
import glyph.*;
public class SimpleCompositor implements Compositor{

    private Composition composition;
    //Bounds cursor;
    @Override
    public void setComposition(Composition compositionGlyph) {
        this.composition = compositionGlyph;
    }

    @Override
    public void compose() {
        Bounds cursor = new Bounds();
        // Find out where we begin, and update our cursor
        System.out.println("A");
//        cursor.set(this.composition.getBounds());
        this.composition.setCursor(cursor); //big change here
        System.out.println("B");
        for(int i=0; i < this.composition.numChild(); i++) {
            // ask child to set size based on window
            this.composition.getChild(i).setSize();
            // set child bounds based on cursor
            this.composition.getChild(i).setPosition(cursor);
            System.out.println("C");
            // compose child (recursive)
            this.composition.getChild(i).compose();
            // update parent with these new bounds
            this.composition.updateBounds(cursor,this.composition.getChild(i).getBounds());
            System.out.println("D");
        }
        //this.composition.updateBounds(cursor,null);
        System.out.println("E");
        this.composition.bounds.print();


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
