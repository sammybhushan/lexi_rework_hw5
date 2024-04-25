// OOP DESIGN PATTERNS:
// Strategy

package glyph;

import compositor.Compositor;
import compositor.SimpleCompositor;

public abstract class Composition extends CompositeGlyph{
    // This is a group of glyphs (composite) that can be composed (call composer)
    Compositor compositor;
    GlyphFinder glyphFinder;

    public Composition(Compositor compositor){
        super();
        this.compositor = compositor;
        compositor.setComposition(this);

        // add finder
        this.glyphFinder = new GlyphFinder();
        glyphFinder.setComposition(this);    }
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
        if(this.getParent() == null){
            this.bounds.yS=0;
            this.bounds.yE=0;
            this.bounds.xS=0;
            this.bounds.xE=0;
        }
        this.compositor.compose();
    }
    public Glyph find(int x, int y){
        return this.glyphFinder.find(x,y);
    }
}
