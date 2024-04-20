package window;
public class SwingWindowFactory extends WindowFactory{
    //private static WindowFactory SwingWindowFactory;
    static WindowFactory makeFactory(){
        return new SwingWindowFactory();
    }
    public WindowImp createWindowImp(String title, Window window){
        return new SwingWindow(title,window);
    }
}
