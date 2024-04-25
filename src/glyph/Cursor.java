//// OOP DESIGN PATTERNS:
//// Decorator
//// Composite
//package glyph;
//
//import window.Window;
//import compositor.Compositor;
//
//public class Cursor extends Embellishment{
//    int width;
//    public Cursor(Compositor compositor) {
//        super(compositor);
//        this.width = 0;
//    }
//
//    public void draw(Window window){
//
//        window.addBorder(this.bounds.xS,this.bounds.yS,this.bounds.xE,this.bounds.yE,1);
//        //this.children.get(0).draw(window);
//    }
//    @Override
//    public void setPosition(Bounds cursor) {
//
//        // set start bounds
//        this.bounds.xS = cursor.xS;
//        this.bounds.yS = cursor.yS;
//
//        // update cursor for decorated
//        cursor.xS += this.width;
//        cursor.yS += this.width;
//
//        // ask child to set position
//        //this.getChild(0).setPosition(cursor);
//
//        // x
////        this.bounds.xE = cursor.xS + this.width;
////        cursor.xS = this.bounds.xS + this.width;
////        // y
//        this.bounds.yE = cursor.yS + this.width;
////        cursor.yS = this.bounds.yS + this.width;
//    }
//
//    @Override
//    public void updateBounds(Bounds cursor, Bounds child) {
//        // passing the current cursor, and the new bounds of the child
//        if(child == null){
//            // update bounds only
//        }
//        else {
//            this.bounds.xE = child.xE + this.width;
//            // if row got longer, update bounds and cursor
////            if (this.bounds.xE + this.width < child.xE) {
////                this.bounds.xE = child.xE + this.width;
////                cursor.xS = child.xE;
////            }
//            // if row got taller, update bounds but keep cursor the same
//            if (this.bounds.yE + this.width < child.yE) {
//                this.bounds.yE = child.yE + width;
//            }
//            //this.getChild(0).setPosition(cursor);
//        }
//    }
//
//    @Override
//    public void setCursor(Bounds cursor) {
//        // updating bounds for children
//        // for a border, we will move by 1x width and height
//        cursor.xS = this.bounds.xS + width;
//        cursor.yS = this.bounds.yS + width;
//
//    }
//
//    @Override
//    public int remove(Glyph glyph) {
//        // remove the cursor embellishment fom the glyph
//        // and re-add it to the parent
//        this.getParent().insert(this.getChild(0),this.index);
//        this.getChild(0).setParent(this.parent);
//
//        return index; // todo: check this
//
//    }
//    public void curse(Glyph glyph){
//        if(children.isEmpty()){
//            // the glyph here is already part of the document structure
//            // the key here is to quietly nest this decorator in here
//            if(glyph.getParent() != null) {
//                // TODO: this remove will cause a compose, but we don't want that yet
//                int previndex = glyph.getParent().remove(glyph);
//                this.setParent(glyph.getParent());
//                this.getParent().insert(this,previndex);
//                //             System.out.println("Removed from idx:" + previndex);
//            }
//            glyph.setParent(this);
//            this.children.add(0,glyph);
//            this.startCompose();
//        }
//        else if(children.size() == 1){
//            // forward this call to the child; embellishment is already embellishing
//            //this.getChild(0).insert(glyph,index);
//            this.startCompose();
//        }
//        else{
//            System.out.println("WARNING: embellishment has multiple children");
//        }
//    }
//}