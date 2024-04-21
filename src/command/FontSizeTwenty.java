package command;

import window.Window;

public class FontSizeTwenty implements Command{

    Window window;
    int prevSize;
    public FontSizeTwenty(Window window){
        this.window = window;
    }
    public FontSizeTwenty(Window window, int prevSize){
        this.window = window;
        this.prevSize = prevSize;
    }
    @Override
    public void execute() {
        prevSize = window.getFontSize();
        this.window.setFontSize(20);
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
        Command newCmd = new FontSizeTwenty(this.window,prevSize);
        return newCmd;
    }
}
