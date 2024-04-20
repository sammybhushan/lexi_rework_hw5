// OOP DESIGN PATTERNS:
// Strategy
package compositor;

import glyph.Composition;

public interface Compositor {
    public void setComposition(Composition specificComposition);
    public void compose();
}
