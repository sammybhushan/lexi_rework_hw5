package command;

public class Redo implements Command {
    @Override
    public void execute() {
        CommandHistory.redoCommand();
    }
    @Override
    public void unexecute() {
        // not allowed (we have redo)
    }

    @Override
    public boolean undoable() {
        return false;
    }

    @Override
    public Command clone() {
        return null;
    }
}
