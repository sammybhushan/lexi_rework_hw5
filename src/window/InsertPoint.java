// Singleton
//
package window;


public class InsertPoint {
    public static InsertPoint insertionPoint;


    public static InsertPoint getInsertionPoint(){
        if(insertionPoint == null){
            insertionPoint = new InsertPoint();

        }
        return insertionPoint;
    }
    public static void setInsertionPoint(){

    }
}
