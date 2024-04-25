package window;
import command.*;
import glyph.Glyph;
public abstract class Window {

  WindowImp windowSystem;
  Glyph mainGlyph;
  KeyMap keyMap;

  public Window(String title){
    windowSystem = WindowFactory.getFactory().createWindowImp(title,this);
    keyMap = new KeyMap();
  }

  public void drawCharacter(char c, int x, int y){
    windowSystem.drawCharacter(c,x,y);
  }
  public void drawRectangle(int x, int y, int width, int height){
    windowSystem.drawRectangle(x,y,width,height);
  }

  public int charWidth(char c){
    return windowSystem.charWidth(c);
  }
  public int charHeight(char c){
    return windowSystem.charHeight(c);
  }

  public void setContents(){ // removing glyph argument?
    windowSystem.setContents();
  }

  public void addBorder(int x1, int y1, int x2, int y2, int width){
    windowSystem.addBorder(x1,y1,x2,y2,width);
  }
  public void addScrollBar(int x, int y, int width, int height){
    windowSystem.addScrollBar(x,y,width,height);
  }

  public void drawButton(int x, int y, int width, int height, String color){
    windowSystem.drawButton(x,y,width,height,color);
  }
  public void drawLabel(int x, int y, int width, int height, String color){
    windowSystem.drawLabel(x,y,width,height,color);
  }
  public void draw(){
    InsertPoint.getInsertPoint().draw(this);
    this.mainGlyph.draw(this);
  }

  public int getFontSize(){
    return this.windowSystem.getFontSize();
  }
  public void setFontSize(int size){
    this.windowSystem.setFontSize(size);
  }
  public void key(char keyPressed){
    Command cmd;
     if(keyPressed >='.' && keyPressed <= '~'){
       cmd = new InsertCharGlyph(this,keyPressed);
    }
     else {
       cmd = keyMap.get(keyPressed); // consult keymap here
     }

    if(cmd == null){return;}

    cmd.execute();   // run command
    CommandHistory.addCommand(cmd);
    //TODO: update history

  }
  public void click(int x, int y){
    Glyph clickedGlyph = mainGlyph.find(x,y);
    if(clickedGlyph != null) {
      System.out.println("FOUND ONE");
      Command cmd = clickedGlyph.click().clone();
      if (cmd != null) {
        cmd.execute();//execute clicked glyph
        CommandHistory.addCommand(cmd);
      }
    }
    windowSystem.repaint();

    // find child glyph
    // run click on found glyph
    // execute the command returned
    // update cmd hist structure
  }
  public void repaint(){
    mainGlyph.compose();
    windowSystem.repaint();
  }

}
