public class Test {
    
    public static void main(String args[]){
         
        Vector v = new Vector(3);
        v.set(0, 1);
        v.set(1, 2);
        v.set(2, 3);
        v.printVector();
        System.out.println("----");
        v.zero();
        v.printVector();
        System.out.println("----");

        Matrix m = new Matrix(2, 2);
        m.set(0, 0, 0);
        m.set(0, 1, 0);
        m.set(1, 0, 0);
        m.set(1, 1, 1);
        m.print();
        System.out.println("----");
        m.zero();
        m.print();

        System.out.println("----");
         
        Matrix m2 = new Matrix(3, 3);
        m2.create3DRotationMat(Math.PI/2);
        System.out.println("Matrix: ");
        m2.print();

        Vector v2 = new Vector(3);
        v2.set3D(1, 0, 0);
        System.out.println("\nVector: ");
        v2.printVector();
        v2.multiplyMat(m2);
        System.out.println("\nMatrix*vector: ");
        v2.printVector();
    }
    
}
