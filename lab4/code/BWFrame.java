public class BWFrame extends Frame {
    
    public BWFrame(int n, int m){
        super(n, m);
    }

    @Override
    public void changeBrightness(double delta){
        super.multiply(delta);
    }

    public void set(int i, int j, int val){
        super.set(i, j, val);
    }

    public int getBW(int i, int j){
        return (int)super.get(i, j);
    }


}
