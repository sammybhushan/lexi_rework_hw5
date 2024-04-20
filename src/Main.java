import java.awt.*;
import java.io.Console;

import compositor.SimpleCompositor;
import glyph.*;
import window.*;
import window.Window;
import glyph.Character;
public class Main {
    public static void main(String[] args ){
        Glyph myCol = new Column(new SimpleCompositor());
        Window mainWindow = new ApplicationWindow("Main Window",myCol);//,windowFactory.createWindowImp());

        Row myRow = new Row("ASDF", new SimpleCompositor(),mainWindow);
        Row myRow2 = new Row("JKL:",new SimpleCompositor(),mainWindow);

        Character a = new Character('A',mainWindow);
        Character b = new Character('B',mainWindow);
        Column myCol2 = new Column(new SimpleCompositor());
        myCol2.insert(a,0);
        myCol2.insert(b,1);

        myCol.insert(myRow,0);
        myCol.insert(myRow2,1);
        myRow.insert(myCol2,2);




        mainWindow.setContents();
    }
}
