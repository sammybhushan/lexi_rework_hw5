// Factory
package glyph;
import compositor.*;
public class RedFactory extends GUIFactory{
    private static RedFactory redFactory;
    // MAKE THIS SINGLETON TOO
        protected static GUIFactory makeFactory(){
        if (redFactory == null){
            redFactory = new RedFactory();
        }
        return redFactory;
    }
    @Override
    public Button createButton() {
        return new RedButton(new SimpleCompositor());
    }

    @Override
    public Label createLabel() {
        return new RedLabel(new SimpleCompositor());

    }
}
