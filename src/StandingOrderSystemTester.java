import java.util.*;

public class StandingOrderSystemTester {

    static int testCount = 0;
    static String test;

    public static void main(String [] args) throws Exception {
        //testInit();
        //testUC1();
        testUC2();
        //testUC3();
        //testUC4();
        //testUC5();
        //testUC6();

        // for a complicated use case, such as use case 4, you should
        // consider having more than one test method
    }

    // test creation of new system
    public static void testInit() throws Exception {
        test = "TEST UC0: Create new system";
        StandingOrderSystem sos = new StandingOrderSystem();
        System.out.println("\n" + test + "\n" + sos);
    }

    // test add new product
    public static void testUC1() throws Exception {
        test = "TEST UC1: Add product";

        // create a new system object
        StandingOrderSystem sos = new StandingOrderSystem();

        // test valid products
        sos.addProduct("P1", "Coke");
        sos.addProduct("P2", "Pepsi");
        sos.addProduct("P3", "Fanta");
        System.out.println("\n" + test + "\n" + sos);

        // test an invalid product
        try {
            sos.addProduct("P1", "Solo");
        }
        catch(Exception e) {
            //System.out.println("\n" + e.getMessage());
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }
    }

    // test add new customer with one delivery address
    public static void testUC2() throws Exception {
        test = "TEST UC2: Add customer";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        sos.addProduct("P1", "Coke");

        // then test some valid cases
        int [] quantities = { 20, 20, 20, 20, 20, 10, 0};
        sos.addCustomer("C1", "Smith",
                "A1", "1 Street-1", "Suburb-1", "John", "1111",
                "ORD1", "P1", "Coke", 1.5, quantities, 1, 100);
        System.out.println("\n" + test + "\n" + sos);

        sos.addCustomer("C2", "Smith-2",
                "A2", "1 Street-2", "Suburb-2", "John-2", "2222",
                "ORD2", "P1", "Coke", 2.5, quantities, 2, 200);
        System.out.println("\n" + test + "\n" + sos);

        // then some invalid cases

        // customerID already exists
        /*try {
            sos.addCustomer("C1", "Smith-3",
                    "A3", "1 Street-3", "Suburb-3", "John-3", "3333",
                    "ORD3", "P1", "Coke", 3.5, quantities, 3, 300);
        }
        catch(Exception e) {
            System.out.println("\n" + e.getMessage());
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // addressID already exists
        try {
            sos.addCustomer("C3", "Smith-3",
                "A3", "1 Street-3", "Suburb-3", "John-3", "3333",
                "ORD3", "P1", "Coke", 3.5, quantities, 3, 300);
        }
        catch(Exception e) {
            System.out.println("\n" + e.getMessage());
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // productID doesn't exists
        try {
            sos.addCustomer("C4", "Smith-4",
                "A4", "1 Street-4", "Suburb-4", "John-4", "4444",
                "ORD4", "P2", "Fanta", 4.5, quantities, 4, 400);
        }
        catch(Exception e) {
            System.out.println("\n" + e.getMessage());
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }*/
    }

    // test add delivery address to an existing customer
    public static void testUC3() throws Exception {
        test = "TEST UC3: Add delivery address to an existing customer";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        sos.addAddress("C1", "A1", "1 Street-1", "Suburb-1", "John", "1111");
        System.out.println("\n" + test + "\n" + sos);
    }

    // test add standing order to an existing customer
    public static void testUC4() throws Exception {
        test = "TEST UC4: Add standing order to an existing customer";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        int [] quantities = { 20, 20, 20, 20, 20, 10, 0};

        sos.addStandingOrder("O1",
                "C1", "Smith",
                "A1", "1 Street-1", "Suburb-1", "John", "1111",
                "P1", "Coke",
                1.5, quantities, 1, 100, "Active");
        System.out.println("\n" + test + "\n" + sos);
    }

    // test list standing orders
    public static void testUC5() throws Exception {
        test = "TEST UC5: List standing orders that need to be filled for a particular date";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();

        //TODO list standing orders
    }

    // test add a delivery
    public static void testUC6() throws Exception {
        test = "TEST UC5: Add a delivery";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        int [] quantities = { 20, 20, 20, 20, 20, 10, 0};

        sos.addDelivery("D1",
                "C1", "Smith",
                "A1", "1 Street-1", "Suburb-1", "John", "1111",
                1, 2,
                "O1",
                "P1", "Coke",
                1.5, quantities, 1, 100, "Active",
                100, 50);
        System.out.println("\n" + test + "\n" + sos);
    }
}
