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
            history = new ArrayList<>();
            pointer = 0;

        }
        return singleCmdHist;
    }
    public static void addCommand(Command justRan){
        if(justRan.undoable()) {
            // here we need to dump the redos available
            while(history.size() > pointer+1) {
                history.removeLast();
            }
            history.add(justRan);
            pointer = history.size() - 1;
        }
    }
    public static void undoCommand(){
        if(pointer < 0){
            System.out.println("No more undo's available");
            return;
        }
        if(history.size() > pointer) {
            history.get(pointer).unexecute();
            pointer--;
        }
//        System.out.println("UNDO");
//        System.out.println(history.size());
//        System.out.println(pointer);
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
