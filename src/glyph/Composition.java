// OOP DESIGN PATTERNS:
// Strategy

package glyph;

import compositor.Compositor;
import compositor.SimpleCompositor;

public abstract class Composition extends CompositeGlyph{
    // This is a group of glyphs (composite) that can be composed (call composer)
    Compositor compositor;

    public Composition(Compositor compositor){
        this.compositor = compositor;
        compositor.setComposition(this);
    }
    public void startCompose(){
        if(this.getParent() == null){
            // we are at the root, begin composition
            this.bounds.yS=0;
            this.bounds.yE=0;
            this.bounds.xS=0;
            this.bounds.xE=0;
            this.compositor.compose();
        }
        else{
            // somewhere in the tree, go up
            this.getParent().startCompose();
        }
    }
    public void compose(){
        this.compositor.compose();
    }
}
