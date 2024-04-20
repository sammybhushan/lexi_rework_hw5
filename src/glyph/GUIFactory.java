// Singleton, Abstract Factory
package glyph;
public abstract class GUIFactory {
    private static GUIFactory singleFactory;

    public static GUIFactory getFactory(){
        if (singleFactory == null){
            String lookFeelType = System.getenv("LEXI_LOOK_FEEL");
            /// DEBUG
            //lookFeelType = "Green";

            if (lookFeelType == null){
                try {
                    throw new Exception("Look_Feel_Env");
                }catch(Exception E){
                    System.out.println("WARNING: Look and feel LEXI_LOOK_FEEL env variable undefined "+
                            "setting Green by default");
                    singleFactory = GreenFactory.makeFactory();

                    //System.exit(1);
                }
            }
            else if(lookFeelType.equals("Green")){
                singleFactory = GreenFactory.makeFactory();
            }
            else if(lookFeelType.equals("Red")){
                singleFactory = RedFactory.makeFactory(); //new RedFactory();
            }
            else {
                try {
                    throw new Exception("Look_Feel_Env");
                }catch(Exception E){
                    System.out.println("ERR: Look and feel LEXI_LOOK_FEEL env variable invalid: " + lookFeelType);
                    System.exit(1);
                }
            }
        }
        return singleFactory;
    }
    abstract Button createButton();
    abstract Label createLabel();

}
