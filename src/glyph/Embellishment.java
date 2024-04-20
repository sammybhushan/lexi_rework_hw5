// OOP DESIGN PATTERNS:
// Decorator
// Composite
package glyph;
import compositor.Compositor;
abstract class Embellishment extends Composition{
    public Embellishment(Compositor compositor) {
        super(compositor);
    }
    @Override
    public Glyph getChild(int index){
        return this.children.get(index);
    }
    @Override
    public void insert(Glyph glyph, int index){
        if(children.isEmpty()){
            // the glyph here is already part of the document structure
            // the key here is to quietly nest this decorator in here
            if(glyph.getParent() != null) {
                // TODO: this remove will cause a compose, but we don't want that yet
                int previndex = glyph.getParent().remove(glyph);
                this.setParent(glyph.getParent());
                this.getParent().insert(this,previndex);
                //             System.out.println("Removed from idx:" + previndex);
            }
            glyph.setParent(this);
            this.children.add(0,glyph);
            this.startCompose();
        }
        else if(children.size() == 1){
            // forward this call to the child; embellishment is already embellishing
            this.getChild(0).insert(glyph,index);
        }
        else{
            System.out.println("WARNING: embellishment has multiple children");
        }
    }
}
