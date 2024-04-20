package window;
public class AwtWindowFactory extends WindowFactory{
    //private static WindowFactory AwtWindowFactory;
    public static WindowFactory makeFactory(){
       return new AwtWindowFactory();
    }
    public WindowImp createWindowImp(String title, Window window) {
        return new AwtWindow(title,window);
    }
}
