<<<<<<< HEAD
import java.util.*;


public class Delegate extends Member{
    private LinkedList<Regular> dependents;
    private Headquarter headOf;

    public Delegate(String n, int p, String e, Headquarter h){
        super(n, p, e, h);
        dependents = new LinkedList<Regular>();
    }

    public void setHeadOf(Headquarter h){
        headOf = h;
    }

    public String getHeadquarterName(){
        return headOf.getName();
    }

    public void addDependents(Regular r){
        dependents.add(r);
    }

    public void printDependents(){
        System.out.println("Delegate name: "+ super.getName() + " dependents (just regulars): ");
        for(Regular r: dependents){
            System.out.println(" " + r.getName());
        }
    }

    public Headquarter getHeadquarter(){
        Headquarter h = super.getHeadquarter();
        return h;
    }

    public String getName(){
        return super.getName();
    }

    public LinkedList<Regular> getDependents(){
        return dependents;
    }

    public Image genDelegateQR(QRLib q){
        String name = getName();
        String delegateTxt = "This is a QR for a Delegate Member. You dont have to care about rising sea levels, if you live on a mega yatch. Head delegate name: " + name;
        Image img = new Image("DelegateQR.png",800,800);
        img.setBitMatrix(q.generateQRCodeImage(delegateTxt, 800, 800));
        img.save();
        return img;
    }

    public Image genRegularQR(QRLib q){
        String regularTxt = "This is a QR for a Regular Member. Climate change doesnt matter, if you stay indoors.";
        Image img = new Image("RegularQR.png",800,800);
        img.setBitMatrix(q.generateQRCodeImage(regularTxt, 800, 800));
        img.save();
        return img;
    }


    public boolean signUpDelegate(Delegate d, QRLib q, Image i){
        Image img = genDelegateQR(q);
        String name = getName();
        String textQR = q.decodeQRCodeImage(i.getBitmap());
        String delegateTxt = "This is a QR for a Delegate Member. You dont have to care about rising sea levels, if you live on a mega yatch. Head delegate name: " + name; //text of qr delegate
        if(textQR.equals(delegateTxt)){
            //ad delegate to headquarter delegates list
            Headquarter h = d.getHeadquarter();
            h.addMember(d);
            return true;
        }
        return false;
    }

    
    
    public boolean signUpRegular(Regular r, QRLib q, Image i){
        Image img = genDelegateQR(q);
        String textQR = q.decodeQRCodeImage(i.getBitmap());
        String regularTxt = "This is a QR for a Regular Member. Climate change doesnt matter, if you stay indoors."; //text of qr regular
        if(textQR.equals(regularTxt)){
            //ad regular to headquarter member list (as jsut member)
            //do i need to add them to the linkedlist of dependents? or also anywhere else?
            Headquarter h = r.getHeadquarter();
            h.addMember(r);
            this.addDependents(r);
            return true;
        }
        return false;
    }
    


    
    /*optional 
    public void proposeAction(Action a){

    }

    public void signUpAction(Date d){

    }
    */

}
=======
import java.util.*;


public class Delegate extends Member{
    private LinkedList<Regular> dependents;
    private Headquarter headOf;

    public Delegate(String n, int p, String e, Headquarter h){
        super(n, p, e, h);
        dependents = new LinkedList<Regular>();
    }

    public void setHeadOf(Headquarter h){
        headOf = h;
    }

    public String getHeadquarterName(){
        return headOf.getName();
    }

    public void addDependents(Regular r){
        dependents.add(r);
    }

    public void printDependents(){
        System.out.println("Delegate name: "+ super.getName() + " dependents (just regulars): ");
        for(Regular r: dependents){
            System.out.println(" " + r.getName());
        }
    }

    public Headquarter getHeadquarter(){
        Headquarter h = super.getHeadquarter();
        return h;
    }

    public String getName(){
        return super.getName();
    }

    public LinkedList<Regular> getDependents(){
        return dependents;
    }

    public Image genDelegateQR(QRLib q){
        String name = getName();
        String delegateTxt = "This is a QR for a Delegate Member. You dont have to care about rising sea levels, if you live on a mega yatch. Head delegate name: " + name;
        Image img = new Image("DelegateQR.png",800,800);
        img.setBitMatrix(q.generateQRCodeImage(delegateTxt, 800, 800));
        img.save();
        return img;
    }

    public Image genRegularQR(QRLib q){
        String regularTxt = "This is a QR for a Regular Member. Climate change doesnt matter, if you stay indoors.";
        Image img = new Image("RegularQR.png",800,800);
        img.setBitMatrix(q.generateQRCodeImage(regularTxt, 800, 800));
        img.save();
        return img;
    }


    public boolean signUpDelegate(Delegate d, QRLib q, Image i){
        Image img = genDelegateQR(q);
        String name = getName();
        String textQR = q.decodeQRCodeImage(i.getBitmap());
        String delegateTxt = "This is a QR for a Delegate Member. You dont have to care about rising sea levels, if you live on a mega yatch. Head delegate name: " + name; //text of qr delegate
        if(textQR.equals(delegateTxt)){
            //ad delegate to headquarter delegates list
            Headquarter h = d.getHeadquarter();
            h.addMember(d);
            return true;
        }
        return false;
    }

    
    
    public boolean signUpRegular(Regular r, QRLib q, Image i){
        Image img = genDelegateQR(q);
        String textQR = q.decodeQRCodeImage(i.getBitmap());
        String regularTxt = "This is a QR for a Regular Member. Climate change doesnt matter, if you stay indoors."; //text of qr regular
        if(textQR.equals(regularTxt)){
            //ad regular to headquarter member list (as jsut member)
            //do i need to add them to the linkedlist of dependents? or also anywhere else?
            Headquarter h = r.getHeadquarter();
            h.addMember(r);
            this.addDependents(r);
            return true;
        }
        return false;
    }
    


    
    /*optional 
    public void proposeAction(Action a){

    }

    public void signUpAction(Date d){

    }
    */

}
>>>>>>> ba7daf4e63bc33c8fcb67871cc6918a7ccee917b
