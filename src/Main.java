import java.awt.*;
import java.io.Console;

import compositor.SimpleCompositor;
import glyph.*;
import glyph.Button;
import glyph.Cursor;
import glyph.Rectangle;
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
        Window mainWindow = new ApplicationWindow("Main Window",myCol,CommandHistory.getHistory());//,windowFactory.createWindowImp());

        Row startRow = new Row("14",new SimpleCompositor(),mainWindow);
        Row row2 = new Row("20",new SimpleCompositor(),mainWindow);

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
        // test buttons
        if(false){
            Glyph scroll = new Scroller(new SimpleCompositor(),10);
            scroll.insert(startRow,0);
            myCol.insert(scroll,0);
            Glyph border = new Border(new SimpleCompositor(),4);
            border.insert(scroll,0);
            Button button = guiFactory.createButton();
            button.setCommand(new FontSizeFourteen(mainWindow));
            button.insert(border,0);

        }        // test scroller
        if(false){
            Glyph border = new Border(new SimpleCompositor(),4);
            border.insert(startRow,0);
            myCol.insert(border,0);
            startRow.insert(new Character('Y',mainWindow),4);

        }
        if(true){
            Row firstLine = new Row("FirstLine", new SimpleCompositor(), mainWindow);
            Row secondLine = new Row("more Chars", new SimpleCompositor(), mainWindow);
            Row plus = new Row("+", new SimpleCompositor(), mainWindow);
            Row minus = new Row("-", new SimpleCompositor(), mainWindow);
            Row fourteen = new Row("14", new SimpleCompositor(), mainWindow);
            Row twenty = new Row("20", new SimpleCompositor(), mainWindow);
            Glyph border = new Border(new SimpleCompositor(),4);
            border.insert(secondLine,0);


            Glyph rect = new Rectangle(10,1);
            Button p = guiFactory.createButton();
            Button n = guiFactory.createButton();
            Button f = guiFactory.createButton();
            Button t = guiFactory.createButton();
            p.setCommand(new IncrementFont(mainWindow));
            n.setCommand(new DecrementFont(mainWindow));
            f.setCommand(new FontSizeFourteen(mainWindow));
            t.setCommand(new FontSizeTwenty(mainWindow));

            p.insert(plus,0);
            n.insert(minus,0);
            f.insert(fourteen,0);
            t.insert(twenty,0);


            myCol.insert(firstLine,0);
            myCol.insert(border,1);
            myCol.insert(p,2);
            myCol.insert(n,3);
            myCol.insert(f,4);
            myCol.insert(t,5);
            myCol.insert(rect,6);

            firstLine.insert(new Cursor('|',mainWindow),9);
            firstLine.insert(new Character('C',mainWindow),10);







        }
        mainWindow.setContents();
    }
}
