// OOP Patterns
// command
// prototype

package command;

public interface Command {
    public abstract void execute();
    public abstract void unexecute();
    public abstract boolean undoable();
    public abstract Command clone();
}
