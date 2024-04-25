// Singleton
//
package window;

import compositor.SimpleCompositor;
import glyph.*;


public class InsertPoint {
    public static InsertPoint insertionPoint;
    private static Glyph cursor; // glyph where cursor is

    public static InsertPoint getInsertPoint(){
        if(insertionPoint == null){
            insertionPoint = new InsertPoint();
            InsertPoint.cursor = null;

        }
        return insertionPoint;
    }
    public void setCursor(Glyph newCursor){
        cursor = newCursor;
    }

    public void move(Glyph glyph){
        // this glyph was clicked
        cursor = glyph;
    }
    public void draw(Window window){
        if(cursor != null) {
            window.addBorder(cursor.getBounds().xE, cursor.getBounds().yS, cursor.getBounds().xE, cursor.getBounds().yE, 1);
        }

    }
    public void insertGlyph(Glyph glyph){
        if(cursor == null){
            return;
        }
        // we want to add a character here....
        cursor.getParent().insert(glyph,cursor.getIndex()+1);
        move(glyph); // move the cursor to the inserted glyph
    }

    public void forward(){
        if(cursor.getParent().getChild(cursor.getIndex()+1) == null){
            // do nothing, at end of structure
        }
        else{
            // get adjacent child in structure
            cursor = cursor.getParent().getChild(cursor.getIndex()+1);
        }
    }

    public void back(){
        if(cursor.getIndex() == 0){
            // do nothing
        }
        else{
            // get adjacent child in structure
            cursor = cursor.getParent().getChild(cursor.getIndex()-1);
        }
    }
    public Glyph removeGlyph(){
        if(cursor == null)
            return null;
        Glyph removed = cursor;
        int idx = cursor.getParent().remove(cursor);

        // attempt to move cursor
        if(idx > 0) {
            cursor = cursor.getParent().getChild(removed.getIndex() - 1);
        }
        else{
            cursor = null;
        }
        return removed;
    }
    public void removeCursor(){
        cursor = null;
    }

}
