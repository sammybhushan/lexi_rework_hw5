// Factory
package glyph;
import compositor.*;
public class GreenFactory extends GUIFactory{
    private static GreenFactory greenFactory;

    protected static GUIFactory makeFactory(){
        if (greenFactory == null){
            greenFactory = new GreenFactory();
        }
        return greenFactory;
    }
    // MAKE THIS SINGLETON TOO!
    @Override
    public Button createButton() {
        return new GreenButton(new SimpleCompositor());
    }

    @Override
    public Label createLabel() {
        return new GreenLabel(new SimpleCompositor());
    }
}
