package glyph;

import window.Window;

public class Cursor extends Character{
    public Cursor(char newChar, Window window) {
        super(newChar, window);
    }

    @Override
    public void setSize(){
        height = this.window.charHeight(character);
        width = 0; //window.charWidth(character);

    }
}
