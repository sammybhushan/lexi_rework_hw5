// command pattern
// prototype
package command;

public class Undo implements Command {
    @Override
    public void execute() {
        CommandHistory.undoCommand();
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
