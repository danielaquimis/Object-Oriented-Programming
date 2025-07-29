<<<<<<< HEAD

import java.util.*;
import java.time.LocalDateTime;

public class Organisation {
    private String name;
    private LocalDateTime ldt;
    LinkedList <Headquarter> places;
    LinkedList <Action> actions;


    public Organisation(String name) {
        this.name=name;
        places = new LinkedList<Headquarter>();
        actions = new LinkedList <Action>();
    }

    public void addHeadquarters(LinkedList<Headquarter> hq){
        places = hq;
    }

    public void addAction( Action a) {
        actions.add(a);
    }

   public Action getAction(Date d) {
        for (Action a: actions) {
            if ((a.start).equals(d)) {
                return a;
            }
        }
        return null;
    }

    public LinkedList<Delegate> getHeadDelegate(){
        LinkedList<Delegate> heads = new LinkedList<Delegate>();
        for(Headquarter hq: places){
            heads.add(hq.getHead());
        }
        return heads;
    }

    public void printHeadquarters(){
        for(Headquarter h: places){
            System.out.println("Headquarter "+h.getName());
        }
    }

    /*methods (here and there) for printing all members of organisation 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
    */
    public void printMembers(){
        for(Headquarter h: places){
            h.printMembers();
        }
    }

    
=======

import java.util.*;
import java.time.LocalDateTime;

public class Organisation {
    private String name;
    private LocalDateTime ldt;
    LinkedList <Headquarter> places;
    LinkedList <Action> actions;


    public Organisation(String name) {
        this.name=name;
        places = new LinkedList<Headquarter>();
        actions = new LinkedList <Action>();
    }

    public void addHeadquarters(LinkedList<Headquarter> hq){
        places = hq;
    }

    public void addAction( Action a) {
        actions.add(a);
    }

   public Action getAction(Date d) {
        for (Action a: actions) {
            if ((a.start).equals(d)) {
                return a;
            }
        }
        return null;
    }

    public LinkedList<Delegate> getHeadDelegate(){
        LinkedList<Delegate> heads = new LinkedList<Delegate>();
        for(Headquarter hq: places){
            heads.add(hq.getHead());
        }
        return heads;
    }

    public void printHeadquarters(){
        for(Headquarter h: places){
            System.out.println("Headquarter "+h.getName());
        }
    }

    /*methods (here and there) for printing all members of organisation 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
    */
    public void printMembers(){
        for(Headquarter h: places){
            h.printMembers();
        }
    }

    
>>>>>>> ba7daf4e63bc33c8fcb67871cc6918a7ccee917b
}