<<<<<<< HEAD
import java.util.*;

public class Region {
    private String name;
    private LinkedList<City> cities;

    public Region(String n){
        name = n;
    }

    public void setCities(LinkedList<City> cities){
        this.cities = cities;
    }

    public void printCities(){
        for(City c: cities){
            System.out.println(" "+c.getName());
        }
    }

    public String getName(){
        return name;
    }
}
=======
import java.util.*;

public class Region {
    private String name;
    private LinkedList<City> cities;

    public Region(String n){
        name = n;
    }

    public void setCities(LinkedList<City> cities){
        this.cities = cities;
    }

    public void printCities(){
        for(City c: cities){
            System.out.println(" "+c.getName());
        }
    }

    public String getName(){
        return name;
    }
}
>>>>>>> ba7daf4e63bc33c8fcb67871cc6918a7ccee917b
