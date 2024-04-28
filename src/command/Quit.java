// command pattern
// prototype
package command;

public class Quit implements Command{
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void unexecute() {

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
