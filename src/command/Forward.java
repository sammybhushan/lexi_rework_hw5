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
//        InsertPoint.getInsertPoint().forward();
    }

    @Override
    public void unexecute() {
//        InsertPoint.getInsertPoint().back();
    }

    @Override
    public Command clone(){
        return new Back(window);
    }

}
