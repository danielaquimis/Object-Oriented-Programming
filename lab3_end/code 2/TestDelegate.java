import java.util.LinkedList;

public class TestDelegate {
    private static LinkedList<Region> regionslist;
    private static LinkedList<Delegate> headslist;
    private static Organisation organisation;

    public static void main(String [] args){
        
        LinkedList<String[]> headquarters = Utility.readXML("headquarter");
        LinkedList<String[]> heads = Utility.readXML("head");
        LinkedList<String[]> regions = Utility.readXML("region");

        regionslist = new LinkedList<Region>();
        headslist = new LinkedList<Delegate>();

        //other lists so we can store the information of the xml files in the corresponding cities and headquarters
        LinkedList<Headquarter> headquarterslist = new LinkedList<Headquarter>();
        LinkedList<City> citieslist = new LinkedList<City>();

        //reading region xml and saving the cities information in citieslist, and in another Aux citieslist to save the cities into the corresponding region
        for(String[] r: regions){
            Region region = new Region(r[0]);
            LinkedList<City> citieslistAux = new LinkedList<City>();            
            for(int i = 1; i <= r.length/2 ; i++){ //in the xml first are the city names and then at the second half their population
                int p = i + (r.length)/2;
                City c = new City(r[i], r[p]);
                citieslistAux.add(c);
                citieslist.add(c);
            }
            region.setCities(citieslistAux);
            regionslist.add(region);
            //uncomment next lines to check the correctness of populating the organisation

            /* 
            System.out.println("\nRegion: "+region.getName());
            region.printCities();
            */
        }


        //creating instance of organisation
        organisation = new Organisation("organisation_test");


        //reading headqrt. xml and saving in headqrt list
        for(String [] hq: headquarters){
            Headquarter headquarter = new Headquarter(hq[0], hq[1], organisation);
            headquarterslist.add(headquarter);

            //now adding list of cities of each headquarter
            LinkedList<City> citieslistAUX= new LinkedList<City>();
            for(int i =2; i<hq.length; i++){
                String cityname_xml = hq[i];
                for(City c: citieslist){ //in the citylist
                    // for each city in region xml,, if c.cityname is in headquater xml, add to them both
                    if(cityname_xml.equals(c.getName())){
                        citieslistAUX.add(c);
                        c.addHeadQuarter(headquarter);
                    }
                } 
            }
            headquarter.setCities(citieslistAUX);
        }
        organisation.addHeadquarters(headquarterslist);
        
        
        //reading heads.xml and also using headquarters list
        for(String[] d: heads){
            for(Headquarter h: headquarterslist){
                if(h.getName().equals(d[3])){ //in d[3] there is the name of the headquarter
                    //if the headquarter of the xml equals the headquarter of our list:
                    Delegate delegate = new Delegate(d[0], Integer.parseInt(d[1]), d[2], h);
                    
                    //adding information of the member (delegate)
                    LinkedList<String> days = new LinkedList<String>();
                    String separator = "\\.";
                    for(String a: d[4].split(separator)){
                        days.add(a);
                    }
                    LinkedList<Integer> hours = new LinkedList<Integer>();
                    for(String b: d[5].split(separator)){
                        hours.add(Integer.parseInt(b));
                    }
                    Availability a = new Availability(days, hours);
                    delegate.setAvailability(a);
                    headslist.add(delegate);
                    delegate.setHeadOf(h);
                    h.setHead(delegate);
                    
                }
            } 
        }

        
        // Testing QR
        System.out.println("--------");

        Delegate hDelegate = headslist.get(0);
        QRLib qrl = new QRLib();
        Image imageDelegate = hDelegate.genDelegateQR(qrl);
        String textQR_delegate = qrl.decodeQRCodeImage(imageDelegate.getBitmap());
        Image imageRegular = hDelegate.genRegularQR(qrl);
        String textQR_regular = qrl.decodeQRCodeImage(imageRegular.getBitmap());
        Headquarter headOf = hDelegate.getHeadquarter();

        //creating members to add
        Delegate delegate1 = new Delegate("laia", 000, "laia@gmail.com", headOf);
        Regular regular = new Regular("daniela", 987, "daniela@gmail.com", headOf, hDelegate);
        Regular regular2 = new Regular("marina", 987, "marina@gmail.com", headOf, hDelegate);
        Regular regular3 = new Regular("enric", 98766, "enric@gmail.com", headOf, hDelegate);
        Delegate delegate2 = new Delegate("rut", 464739, "rut@gmail.com", headOf);
        Delegate delegate3 = new Delegate("anna", 986, "anna@gmail.com", headOf);

        System.out.println("Dependents before sign up: ");
        hDelegate.printDependents();

        if (textQR_delegate.contains(hDelegate.getName())){ //
            boolean booldelegate = hDelegate.signUpDelegate(delegate1, qrl, imageDelegate);
            boolean boolregular = hDelegate.signUpRegular(regular, qrl, imageDelegate); //false because we are trying to sign up a regular member with the delegate image
            boolean boolregular2 = hDelegate.signUpRegular(regular2, qrl, imageRegular); 
            boolean boolregular3 = hDelegate.signUpRegular(regular3, qrl, imageRegular);
            boolean booldelegate2 = hDelegate.signUpDelegate(delegate2, qrl, imageRegular); // false bc we are trying to sign up a delegate member with the regular image
            boolean booldelegate3 = hDelegate.signUpDelegate(delegate3, qrl, imageDelegate);
            System.out.println("\nSign up completed for member: " + delegate1.getName() + " : " + booldelegate);
            System.out.println("Sign up completed for member: " + regular.getName() + " : " + boolregular);
            System.out.println("Sign up completed for member: " + regular2.getName() + " : " + boolregular2);
            System.out.println("Sign up completed for member: " + regular3.getName() + " : " + boolregular3);
            System.out.println("Sign up completed for member: " + delegate2.getName() + " : " + booldelegate2);
            System.out.println("Sign up completed for member: " + delegate3.getName() + " : " + booldelegate3);
        }

        System.out.println("Dependents after sign up: ");
        hDelegate.printDependents();
        headOf.printMembers();
       
        System.out.println("\n-----------------\nprinting members of the organisation:");
        organisation.printMembers();

        //uncomment next lines to check the correctness of populating the organisation
        
        /* 
        System.out.println("\n--------\nChecking correctness of organisation\n");

        organisation.printHeadquarters();
        
        System.out.println("--------");
        for(Headquarter hq: headquarterslist){
            System.out.println("\nHeadquarter name: " + hq.getName() + " cities:");
            hq.printCities();
        }

        System.out.println("--------");
        for(City c: citieslist){
            System.out.println("\nCity name: " + c.getName() + " headquarter:");
            c.printHeadquarters();
        }

        System.out.println("--------");

        for(Delegate d: headslist){
            System.out.println("\nDelegate name: "+ d.getName()+ " head of: " + d.getHeadquarterName());
            
        }
        */

    }
    
}
