<<<<<<< HEAD
import java.util.*;

public class Regular extends Member{
    private Delegate responsible;
    private LinkedList<Vehicle> vehicles;

    public Regular(String n, int p, String e, Headquarter h, Delegate r){
        super(n, p, e, h);
        responsible = r;
    }

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public boolean participate(Action a){
        Headquarter h = getHeadquarter();
        if(h.actionsParticipated.contains(a)){
            return true;
        }
        return false;
    }
}
=======
import java.util.*;

public class Regular extends Member{
    private Delegate responsible;
    private LinkedList<Vehicle> vehicles;

    public Regular(String n, int p, String e, Headquarter h, Delegate r){
        super(n, p, e, h);
        responsible = r;
    }

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public boolean participate(Action a){
        Headquarter h = getHeadquarter();
        if(h.actionsParticipated.contains(a)){
            return true;
        }
        return false;
    }
}
>>>>>>> ba7daf4e63bc33c8fcb67871cc6918a7ccee917b
