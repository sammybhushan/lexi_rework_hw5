package window;
import glyph.Glyph;
public abstract class Window {

  WindowImp windowSystem;
  Glyph mainGlyph;

  public Window(String title){
    windowSystem = WindowFactory.getFactory().createWindowImp(title,this);
  }

  public void drawCharacter(char c, int x, int y){
    windowSystem.drawCharacter(c,x,y);
  }
  void drawRectangle(int x, int y, int width, int height){
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
    this.mainGlyph.draw(this);
  }

}
