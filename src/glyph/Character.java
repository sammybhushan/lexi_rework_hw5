// OOP DESIGN PATTERNS:
// Composite
package glyph;
import command.Command;
import window.Window;
public class Character extends Glyph{
    private char character;
    private Window window;
//    private Bounds bounds;
    private int height;
    private int width;
    public Character(char newChar,Window window)
    {
        character = newChar;
        this.window = window;
        bounds = new Bounds();
    }
    public void draw(Window window) {
//        window.setContents(this);
        window.drawCharacter(this.character, bounds.xS, bounds.yS);
        System.out.println("DRAWING CHAR " + this.character);
    }
    public void insert(Glyph newGlyph,int index){
        try {
            throw new Exception("Invalid Insert");
        }catch(Exception E){
            System.out.println("Cannot insert into char glyph");
        }
    }
    public int remove(Glyph glyph){
        try {
            throw new Exception("Invalid Remove");
        }catch(Exception E){
            System.out.println("Cannot remove from char glyph");
            return 0;
        }
    }

    public Glyph getChild(int index){
        try {
            throw new Exception("Invalid");
        }catch(Exception E){
            System.out.println("Cannot get child from char glyph");
        }
        return null;
    }


    public void startCompose() {
        this.getParent().startCompose();
    }


    public void compose(){
        // this doesn't do anything
        // However, it will be called by the compositor as the end of the recursion
//        try {
//            throw new Exception("Invalid");
//        }catch(Exception E){
//            System.out.println("Cannot get child from char glyph");
//        }
    }
    public void setPosition(Bounds cursor) {
        // take the starting x,y location and set bounds accordingly
        this.bounds.xS = cursor.xS;
        this.bounds.yS = cursor.yS;
        this.bounds.xE = cursor.xS + this.width;
        this.bounds.yE = cursor.yS + this.height;

        cursor.xS = this.bounds.xE; // update cursor to xS
//        cursor.xE (un needed???)
        //cursor.yS =
//        if(cursor.yE < this.bounds.yE){
//            cursor.yE = this.bounds.yE;
//        }
    }
    public void setSize(){
        height = this.window.charHeight(character);
        width = window.charWidth(character);
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }

    @Override
    public void setCursor(Bounds cursor) {
        // dummy
    }

    @Override
    public void updateBounds(Bounds cursor, Bounds childBounds) {

    }
}
