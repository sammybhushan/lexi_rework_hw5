// command pattern
// prototype
package command;

import window.Window;

public class FontSizeFourteen implements Command{

    Window window;
    int prevSize;
    public FontSizeFourteen(Window window){
        this.window = window;
    }
    public FontSizeFourteen(Window window, int prevSize){
        this.window = window;
        this.prevSize = prevSize;
    }
    @Override
    public void execute() {
        prevSize = window.getFontSize();
        this.window.setFontSize(14);
        this.window.repaint();

    }

    public void unexecute(){
        this.window.setFontSize(prevSize);
        this.window.repaint();
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public Command clone() {
        Command newCmd = new FontSizeFourteen(this.window,prevSize);
        return newCmd;
    }
}
