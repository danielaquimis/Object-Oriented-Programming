<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.*;


public class Action {
    private String purpose;
    Date start;
    private int duration;
    private LinkedList<Headquarter> headquarters;
    private LinkedList<InfoAction> developedActions;

    public Action(String p, Date s, int d){
        start = s;
        purpose = p;
        duration = d;
    }

    public void addHeadquarter(Headquarter h){
        headquarters.add(h);
    }
    

}
=======
import java.time.LocalDateTime;
import java.util.*;


public class Action {
    private String purpose;
    Date start;
    private int duration;
    private LinkedList<Headquarter> headquarters;
    private LinkedList<InfoAction> developedActions;

    public Action(String p, Date s, int d){
        start = s;
        purpose = p;
        duration = d;
    }

    public void addHeadquarter(Headquarter h){
        headquarters.add(h);
    }
    

}
>>>>>>> ba7daf4e63bc33c8fcb67871cc6918a7ccee917b
