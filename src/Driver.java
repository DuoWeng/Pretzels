import java.util.Arrays;
import java.util.Iterator;

/**
 * Class to Test the program
 */
public class Driver {

    /**
     * Check some basics
     *
     * @return
     */
    public static boolean test1(StreetParking sp)
    {
        sp.reset();
        int i = sp.size();
        if (i != 1)
            return false;

        sp.setCapacity(6);
        int c = sp.capacity();
        if (c != 6)
            return false;

        boolean b = sp.isBlockedExit();
        if (b)
            return false;

        sp.blockExit();
        b = sp.isBlockedExit();

        if (!b)
            return false;

        //single car George in the street
        Iterator<String> it = sp.iterator();
        if (!it.hasNext())
            return false;

        if (!it.next().equals("George"))
            return false;

        return true;

    }


    public static boolean test2(StreetParking sp)
    {
        sp.reset();
        int i = sp.size();
        if (i != 1)
            return false;

        sp.add("Jerry");
        sp.add("Elaine");
        sp.add("Cosmo");
        sp.add("Newman");

        //this should fail
        boolean b = sp.add("Bob Sacameno");

        if (b)
            return false;

        int sz = sp.size();

        if(sz != 5)
            return false;
        sp.remove("Elaine");

        sz = sp.size();

        if (sz != 4)
            return false;


        sp.blockExit();

        sp.remove("Jerry");
        Iterator<String> it = sp.iterator();

        String s = it.next();

        if (!s.equals("George"))
            return false;

        s = it.next();
        if (!s.equals("Newman"))
            return false;

        return true;
    }

    public static void runTests(StreetParking sp)
    {
        System.out.print("Test 1: ");
        System.out.println( (test1(sp) ? "passed" : "failed") );

        System.out.print("Test 2: ");
        System.out.println( (test2(sp) ? "passed" : "failed") );


        //the grader will run additional unknown tests as part of the functionality grade
    }



    public static void main(String [] args)
    {
        System.out.println("Running Tests on your street parking implementation");


        StreetParking sp1,sp2,sp3;

        // Uncomment this if you implement the DequeStreetParking
        sp1 = new ParkingController();


        // Uncomment this if you implement the ArrayStreetParking
        sp2 = new ArrayStreetParking();



        // Uncomment this if you implement the LinkedStreetParking Doubly linked nodes
        sp3 = new LinkedStreetParking();


        //always uncomment the below line to run the tests
        runTests(sp1);
        runTests(sp2);
        runTests(sp3);

    }

}
