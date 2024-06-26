package glyph;
import java.util.ArrayList;

// This is simply a collection of glyphs (may or may not be composable)
public abstract class CompositeGlyph extends Glyph{
    ArrayList<Glyph> children;

    public CompositeGlyph(){
        parent = null;
        children = new ArrayList<>();
        this.bounds=new Bounds();
    }
    public int remove(Glyph glyph){
        int value = this.children.indexOf(glyph);
        this.children.remove(glyph);
        startCompose();
        return value;
    }
    public void insert(Glyph newGlyph,int index){
        newGlyph.setParent(this);
        this.children.add(index,newGlyph);
        startCompose();
    }
    public Glyph getChild(int index){
        return this.children.get(index);
    }
    public int numChild(){return this.children.size();}
    public void setSize(){
        // do nothing here either
        // from a compose standpoint this can be 0?
    }
}