package command;

import window.*;

public class Back implements Command{
    Window window;
    public Back(Window w){
        window = w;
    }

    @Override
    public boolean undoable() {
        return true;
    }

    @Override
    public void execute() {
        InsertPoint.getInsertPoint().back();
        this.window.repaint();
    }

    @Override
    public void unexecute() {
        InsertPoint.getInsertPoint().forward();
    }

    @Override
    public Command clone(){
        return new Back(window);
    }

}
