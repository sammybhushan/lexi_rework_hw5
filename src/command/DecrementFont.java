package command;

import window.Window;

public class DecrementFont implements Command{

    Window window;
    public DecrementFont(Window window){
        this.window = window;
    }
    @Override
    public void execute() {
        int currSize = window.getFontSize();
        this.window.setFontSize(currSize-1);
        this.window.repaint();

    }
    public void unexecute(){
        int currSize = window.getFontSize();
        if(currSize < 1){
            System.out.println("Reached Minimum Size");
        }
        else {
            this.window.setFontSize(currSize - 1);
            this.window.draw();
        }
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public Command clone() {
        Command newCmd = new DecrementFont(this.window);
        return newCmd;
    }
}
