package command;

import window.*;

public class Forward implements Command{
    Window window;
    public Forward(Window w){
        window = w;
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public void execute() {
        InsertPoint.getInsertPoint().forward();
        this.window.repaint();
    }

    @Override
    public void unexecute() {
        InsertPoint.getInsertPoint().back();
        this.window.repaint();
    }

    @Override
    public Command clone(){
        return new Forward(window);
    }

}
