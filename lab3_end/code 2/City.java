<<<<<<< HEAD
import java.util.*;

public class City {
    private String name;
    private String population;
    private LinkedList<Headquarter> headquarters;

    public City(String n, String p){
        name = n;
        population = p;
        headquarters = new LinkedList<Headquarter>();
    }

    public void addHeadQuarter(Headquarter hq){
        headquarters.add(hq);
    }

    public String getName(){
        return name;
    }
    
    public void printHeadquarters(){
        for(Headquarter hq: headquarters){
            System.out.println(" " + hq.getName());
        }
    }
}
=======
import java.util.*;

public class City {
    private String name;
    private String population;
    private LinkedList<Headquarter> headquarters;

    public City(String n, String p){
        name = n;
        population = p;
        headquarters = new LinkedList<Headquarter>();
    }

    public void addHeadQuarter(Headquarter hq){
        headquarters.add(hq);
    }

    public String getName(){
        return name;
    }
    
    public void printHeadquarters(){
        for(Headquarter hq: headquarters){
            System.out.println(" " + hq.getName());
        }
    }
}
>>>>>>> ba7daf4e63bc33c8fcb67871cc6918a7ccee917b
