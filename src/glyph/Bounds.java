package glyph;
public class Bounds {
    public int xS; //x start
    public int xE; // x end
    public int yS; //y start
    public int yE; //y end
    public Bounds(){
        xS=0;
        xE=0;
        yS=0;
        yE=0;
    }
    public void print(){
        System.out.println("xs:" + xS + " xe:" + xE + " ys:" + yS + " ye:" + yE);
    }
    public void set(Bounds input){
        xS=input.xS;
        xE=input.xE;
        yS=input.yS;
        yE=input.yE;
    }
    public void set(int xStart,int xEnd,int yStart, int yEnd){
        xS = xStart;
        xE = xEnd;
        yS = yStart;
        yE = yEnd;
    }
}
