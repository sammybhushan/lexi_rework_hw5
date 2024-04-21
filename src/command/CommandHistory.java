// OOP Patterns
// singleton

package command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private static CommandHistory singleCmdHist;
    private static ArrayList<Command> history;
    private static int pointer;

    public static CommandHistory getHistory(){
        if(singleCmdHist == null){
            singleCmdHist = new CommandHistory();
            pointer = 0;

        }
        return singleCmdHist;
    }
    public static void addCommand(Command justRan){
        if(justRan.undoable()) {
            history.add(justRan);
            pointer = history.size() - 1;
        }
    }
    public static void undoCommand(){
        history.get(pointer).unexecute();
        pointer--;
    }
    public static void redoCommand(){
        pointer++;
        if(pointer == history.size()){
            pointer--;
            System.out.println("No more Redo");
            return;
        }
        history.get(pointer).execute();

    }
}
