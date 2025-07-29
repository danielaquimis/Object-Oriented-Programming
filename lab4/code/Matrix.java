public class Matrix {
    
    private Vector[] values;
    protected int rows;
    protected int cols;

    public Matrix(int n, int m){
        rows = n;
        cols = m;
        values = new Vector[n];
        for(int i = 0; i<n; i++){
            values[i] = new Vector(m);
        }
    }

    public void set(int i, int j, double val){
        values[i].set(j, val);
    }

    public double get(int i, int j){
        return values[i].get(j);
    }

    public void multiply(double s){
        for(int i = 0; i<rows; i++){
            values[i].multiply(s);
        }
    }

    public void zero(){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                set(i, j, 0);
            }
        }
    }

    public void print(){
        for(int i = 0; i<rows; i++){
            values[i].printVector();
        }
    }

    public void create3DRotationMat(double alpha){
        zero();
        set(0,0, Math.round(Math.cos(alpha)));
        set(0,1, (-1)*Math.sin(alpha));
        set(1,0, Math.sin(alpha));
        set(1,1, Math.round(Math.cos(alpha)));
        set(2,2,1);

    }

}
