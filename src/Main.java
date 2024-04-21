import java.awt.*;
import java.io.Console;

import compositor.SimpleCompositor;
import glyph.*;
import window.*;
import window.Window;
import glyph.Character;
import command.*;
public class Main {
    public static void main(String[] args ){


        // GUI Factory
        GUIFactory guiFactory = GUIFactory.getFactory();

        // Create Main Glyph
        Glyph myCol = new Column(new SimpleCompositor());
        // Create Application Window
        Window mainWindow = new ApplicationWindow("Main Window",myCol);//,windowFactory.createWindowImp());

        Row startRow = new Row("ASDF",new SimpleCompositor(),mainWindow);


        // Add a plus and add a second plus afterwards
        if(false) {
            Glyph plusFont = guiFactory.createButton();
            Glyph minusFont = guiFactory.createButton();
            Row plus = new Row("+", new SimpleCompositor(), mainWindow);

            minusFont.insert(plus, 0);

            myCol.insert(minusFont, 0);
            myCol.insert(startRow, 1);
            plus.insert(new Character('+', mainWindow), 1);
            plus.remove(plus.getChild(0));
        }
        // test scroller
        if(true){
            Glyph scroll = new Scroller(new SimpleCompositor(),10);
            scroll.insert(startRow,0);
            myCol.insert(scroll,0);
            Glyph border = new Border(new SimpleCompositor(),4);
            border.insert(scroll,0);
            Glyph label = guiFactory.createLabel();
            label.insert(border,0);

        }        // test scroller
        if(false){
            Glyph border = new Border(new SimpleCompositor(),4);
            border.insert(startRow,0);
            myCol.insert(border,0);
            startRow.insert(new Character('Y',mainWindow),4);

        }
        mainWindow.setContents();
    }
}
