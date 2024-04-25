package glyph;
import window.*;
public class Rectangle extends Glyph{
    private Window window;
    private Bounds bounds;
    private Glyph parent;

    private int height;
    private int width;
    public Rectangle(int height, int width)
    {
        this.height = height;
        this.width = width;
        bounds = new Bounds();
    }
    @Override
    public void draw(Window window) {
        window.drawRectangle(bounds.xS, bounds.yS, this.width,this.height);
    }

    @Override
    public void insert(Glyph newGlyph, int index) {
        try {
            throw new Exception("Invalid Insert");
        }catch(Exception E){
            System.out.println("Cannot insert into rect glyph");
        }
    }
    @Override
    public int remove(Glyph glyph){
        try {
            throw new Exception("Invalid Remove");
        }catch(Exception E){
            System.out.println("Cannot remove from rect glyph");
            return 1;
        }
    }
    @Override
    public Glyph getChild(int index){
        try {
            throw new Exception("Invalid");
        }catch(Exception E){
            System.out.println("Cannot get child from char glyph");
        }
        return null;
    }

    @Override
    public void startCompose() {
        this.getParent().compose();
    }

    @Override
    public void compose(){
        // this doesn't do anything
        // However, it will be called by the compositor as the end of the recursion
//        try {
//            throw new Exception("Invalid");
//        }catch(Exception E){
//            System.out.println("Cannot get child from char glyph");
//        }
    }
    @Override
    public Glyph getParent(){
        return this.parent;
    }
    @Override
    public void setParent(Glyph parent){
        this.parent = parent;
    }
    @Override
    public void setPosition(Bounds cursor) {
        // take the starting x,y location and set bounds accordingly
        this.bounds.xS = cursor.xS;
        this.bounds.yS = cursor.yS;
        this.bounds.xE = cursor.xS + this.height;
        this.bounds.yE = cursor.yS + this.width;
        cursor.xS = this.bounds.xE;
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }

    @Override
    public void setCursor(Bounds cursor) {
        // will not reach here as rect cannot be composed

    }

    @Override
    public void updateBounds(Bounds cursor, Bounds childBounds) {

    }

    public void setSize(){
        // do nothing; the size of a rectangle is fixed from a compose standpoint
    }
}
