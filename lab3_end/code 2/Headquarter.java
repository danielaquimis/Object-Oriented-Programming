<<<<<<< HEAD
import java.util.*;

public class Headquarter {
    private String name;
    private String email;
    private LinkedList<Member> members;
    private Delegate head;
    protected LinkedList<InfoAction> actionsParticipated;
    private Organisation organisation;
    private LinkedList<City> cities;

    public Headquarter(String n, String e, Organisation o){
        name = n;
        email = e;
        organisation = o;
        members = new LinkedList<Member>();
    }

    public void addMember(Member m){
        members.add(m);
    }

    public void setCities(LinkedList<City> cities){
        this.cities = cities;
    }

    public void printCities(){
        for(City c: cities){
            System.out.println(" " + c.getName());
        }
    }

    public void printMembers(){
        System.out.println("Headquarter: " + name+ ". Head delegate: " + head.getName() + " members: ");
        for(Member m: members){
            System.out.println(" "+m.getName());
        }
    }

    public void signUpAction(Action a, int members, int nonmembers, boolean press){
        InfoAction action = new InfoAction(a, this, members, nonmembers, press);
        actionsParticipated.add(action);
    }

    public void setHead(Delegate d){
        head = d;
    }

    public Organisation getOrganisation(){
        return organisation;
    }

    public Action getAction(Date d){
        return organisation.getAction(d);
    }
    
    public Delegate getHead(){
        return head;
    }

    public String getName(){
        return name;
    }

    public LinkedList<City> getCities(){
        return cities;
    }
}
=======
import java.util.*;

public class Headquarter {
    private String name;
    private String email;
    private LinkedList<Member> members;
    private Delegate head;
    protected LinkedList<InfoAction> actionsParticipated;
    private Organisation organisation;
    private LinkedList<City> cities;

    public Headquarter(String n, String e, Organisation o){
        name = n;
        email = e;
        organisation = o;
        members = new LinkedList<Member>();
    }

    public void addMember(Member m){
        members.add(m);
    }

    public void setCities(LinkedList<City> cities){
        this.cities = cities;
    }

    public void printCities(){
        for(City c: cities){
            System.out.println(" " + c.getName());
        }
    }

    public void printMembers(){
        System.out.println("Headquarter: " + name+ ". Head delegate: " + head.getName() + " members: ");
        for(Member m: members){
            System.out.println(" "+m.getName());
        }
    }

    public void signUpAction(Action a, int members, int nonmembers, boolean press){
        InfoAction action = new InfoAction(a, this, members, nonmembers, press);
        actionsParticipated.add(action);
    }

    public void setHead(Delegate d){
        head = d;
    }

    public Organisation getOrganisation(){
        return organisation;
    }

    public Action getAction(Date d){
        return organisation.getAction(d);
    }
    
    public Delegate getHead(){
        return head;
    }

    public String getName(){
        return name;
    }

    public LinkedList<City> getCities(){
        return cities;
    }
}
>>>>>>> ba7daf4e63bc33c8fcb67871cc6918a7ccee917b
