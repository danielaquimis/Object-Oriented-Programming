import java.util.Arrays;

public class Vector{

    private double[] values;
    private int dim;

    public Vector(int dim){
        this.dim = dim;
        values = new double[dim];
    }

    public void set(int i, double val){
        values[i] = val;
    }

    public double get(int i){
        return values[i];
    }

    public void multiply(double s){
        for(int i = 0; i<values.length; i++){
            values[i] *= s;
        }
    }

    public void zero(){
        for(int i = 0; i<dim; i++){
            set(i, 0);
        }
    }

    //prints in different lines
    public void print(){
        for(int i = 0; i<values.length; i++){
            if (i == 0){
                System.out.println("[" + values[i] +  ",");
            }
            else if (i == (values.length -1)){
                System.out.println(values[i] + "]");
            }
            else{
                System.out.println(values[i] + ",");
            }
        }
    }
    
    //prints all in same line
    public void printVector(){
        System.out.println(Arrays.toString(values));
    }
    
    public void set3D(double i, double j, double k){
        set(0, i);
        set(1, j);
        set(2, k);
    }

    public void multiplyMat(Matrix m){
        if(m.rows == this.dim){
            Vector v = new Vector(3);
            for(int i = 0; i<dim; i++){
                double sum = 0;
                for(int j = 0; j<dim; j++){
                    double m1 = m.get(i, j);
                    double v1 = get(j);
                    sum += v1*m1;
                    
                }
                v.set(i, sum);
            }
            for (int i = 0; i < dim; i++){
                set(i, v.get(i));
            } 
        } else {
            System.out.println("Dimensions don't match. Cannot multiply");
        }
        
    }
}