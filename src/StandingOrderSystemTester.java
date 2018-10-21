import java.util.*;

public class StandingOrderSystemTester {

    static int testCount = 0;
    static String test;

    public static void main(String [] args) throws Exception {
        //testInit();
        //testUC1();
        //testUC2();
        //testUC3();
        //testUC4();
        testUC5();
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
        // product id already exists
        try {
            sos.addProduct("P1", "Solo");
        }
        catch(Exception e) {
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
        Address address = new Address("A1", "Street-1", "Suburb-1", "John-1", "1111");
        sos.addCustomer("C1", "Smith", address);                ;
        System.out.println("\n" + test + "\n" + sos);

        address = new Address("A2", "Street-2", "Suburb-2", "John-2", "2222");
        sos.addCustomer("C2", "Smith-2", address);
        System.out.println("\n" + test + "\n" + sos);

        // then some invalid cases
        // customerID already exists
        address = new Address("A3", "Street-3", "Suburb-3", "John-3", "3333");
        try {
            sos.addCustomer("C1", "Smith-3", address);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // addressID already exists
        address = new Address("A1", "Street-3", "Suburb-3", "John-3", "3333");
        try {
            sos.addCustomer("C3", "Smith-3", address);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }
    }

    // test add delivery address to an existing customer
    public static void testUC3() throws Exception {
        test = "TEST UC3: Add delivery address to an existing customer";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        Address address = new Address("A1", "Street-1", "Suburb-1", "John-1", "1111");
        sos.addCustomer("C1", "Smith-1", address);

        sos.addAddress("C1", "A2", "Street-2", "Suburb-2", "John-2", "2222");
        System.out.println("\n" + test + "\n" + sos);

        // then some invalid cases
        // address id already exists
        try {
            sos.addAddress("C1", "A1", "Street-1", "Suburb-1", "John-1", "1111");
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // customer id doesn't exist
        try {
            sos.addAddress("C3", "A3", "Street-3", "Suburb-3", "John-3", "3333");
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }
    }

    // test add standing order to an existing customer
    public static void testUC4() throws Exception {
        test = "TEST UC4: Add standing order to an existing customer";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        int [] quantities = { 20, 20, 20, 20, 20, 10, 0};

        Customer customer = new Customer("C1", "Smith");
        Address address = new Address("A1", "1 Street-1", "Suburb-1", "John", "1111");
        Product product = new Product("P1", "Coke");

        sos.addProduct("P1", "Coke");
        sos.addCustomer("C1", "Smith", address);

        sos.addStandingOrder("O1", customer, address, product, 1.5, quantities, 1, 100, Order.ORDERSTATUS.active);
        System.out.println("\n" + test + "\n" + sos);

        // then some invalid cases
        // order id already exists
        try {
            sos.addStandingOrder("O1", customer, address, product, 2.5, quantities, 2, 200, Order.ORDERSTATUS.active);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // customer id doesn't exist
        Customer customer2 = new Customer("C2", "Smith-2");
        try {
            sos.addStandingOrder("O2", customer2, address, product, 2.5, quantities, 2, 200, Order.ORDERSTATUS.active);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // product id doesn't exist
        Product product2 = new Product("P2", "Fanta");
        try {
            sos.addStandingOrder("O2", customer, address, product2, 2.5, quantities, 2, 200, Order.ORDERSTATUS.active);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

    }

    // test list standing orders
    public static void testUC5() throws Exception {
        test = "TEST UC5: List standing orders that need to be filled for a particular date";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        int [] quantities = { 20, 20, 20, 20, 20, 10, 0};

        // add some customers
        Customer customer = new Customer("C1", "Smith");
        Customer customer2 = new Customer("C2", "Johnson");
        Customer customer3 = new Customer("C3", "Smith");

        // add some addresses
        Address address = new Address("A1", "1 Street-1", "Suburb-1", "John", "1111");
        Address address2 = new Address("A2", "1 Street-2", "Suburb-2", "John-2", "2222");
        Address address3 = new Address("A3", "1 Street-3", "Suburb-3", "John-3", "3333");

        // add some products
        Product product = new Product("P1", "Coke");
        Product product2 = new Product("P2", "Fanta");
        Product product3 = new Product("P3", "Solo");

        sos.addProduct("P1", "Coke");
        sos.addProduct("P2", "Fanta");
        sos.addProduct("P3", "Solo");

        sos.addCustomer("C1", "Smith", address);
        sos.addCustomer("C2", "Smith", address2);
        sos.addCustomer("C3", "Smith", address3);

        sos.addStandingOrder("O1", customer, address, product, 1.5, quantities, 1, 100, Order.ORDERSTATUS.active);
        sos.addStandingOrder("O2", customer2, address2, product2, 2.5, quantities, 2, 200, Order.ORDERSTATUS.active);
        sos.addStandingOrder("O3", customer3, address3, product3, 3.5, quantities, 3, 300, Order.ORDERSTATUS.active);

        sos.listStandingOrders();
        //System.out.println("\n" + test + "\n" + sos);
    }

    // test add a delivery
    public static void testUC6() throws Exception {
        test = "TEST UC5: Add a delivery";

        // create a system object then add enough data for your testing purpose
        StandingOrderSystem sos = new StandingOrderSystem();
        int [] quantities = { 20, 20, 20, 20, 20, 10, 0};

        Customer customer = new Customer("C1", "Smith");
        Address address = new Address("A1", "1 Street-1", "Suburb-1", "John", "1111");
        Product product = new Product("P1", "Coke");

        sos.addCustomer("C1", "Smith", address);
        sos.addProduct("P1", "Coke");

        sos.addDelivery("D1", customer, address, 100, 1, "O1", product, 1.5, quantities, 1, 100, Order.ORDERSTATUS.active, 100, 10);
        System.out.println("\n" + test + "\n" + sos);

        // then some invalid cases
        // delivery id already exists
        try {
            sos.addDelivery("D1", customer, address, 100, 1, "O1", product, 1.5, quantities, 1, 100, Order.ORDERSTATUS.active, 100, 10);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // customer id doesn't exist
        Customer customer2 = new Customer("C2", "Smith-2");
        try {
            sos.addDelivery("D2", customer2, address, 200, 2, "O2", product, 2.5, quantities, 2, 200, Order.ORDERSTATUS.active, 200, 20);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }

        // address id doesn't exist
        Address address2 = new Address("A2", "Street-2", "Suburb-2", "John-2", "2222");
        try {
            sos.addDelivery("D2", customer, address2, 200, 2, "O2", product, 2.5, quantities, 2, 200, Order.ORDERSTATUS.active, 200, 20);
        }
        catch(Exception e) {
        }
        finally {
            System.out.println("\n" + test + "\n" + sos);
        }
    }
}
