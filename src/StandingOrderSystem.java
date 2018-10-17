import java.util.List;
import java.util.ArrayList;

public class StandingOrderSystem {

    List<Product> productList;
    List<Customer> customerList;
    List<Order> orderList;
    List<Delivery> deliveryList;
    List<Invoice> invoiceList;
    List<Address> addressList;

    public StandingOrderSystem() {
        productList = new ArrayList<Product>();
        customerList = new ArrayList<Customer>();
        orderList = new ArrayList<Order>();
        deliveryList = new ArrayList<Delivery>();
        invoiceList = new ArrayList<Invoice>();
        addressList = new ArrayList<Address>();
    }

    public String toString() {
        String desc = "SOSystem["
                + "\nproductList: " + productList
                + "\ncustomerList: " + customerList
                + "\norderList: " + orderList
                + "\ndeliveryList: " + deliveryList
                + "\ninvoiceList: " + invoiceList
                + "\naddressList: " + addressList + "\n]";

        return desc;
    }

    // atomic use case 1: Add product
    public void addProduct(String id, String description) throws Exception {

        // check precondition that id is new
        Product product = Helper.search(productList, id);
        boolean pre = (product == null);
        if( !pre) {
            String msg = "ERROR MESSAGE: The product id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // add new product
        product = new Product(id, description);
        productList.add(product);
    }

    //TODO quantities not printing to screen correctly
    // atomic use case 2: Add customer
    public void addCustomer(String customerID, String name,
                            String addressID, String line1, String line2, String contactPerson, String contactPhone,
                            String orderID,
                            String productID, String productDescription, Double price, int[] quantities, Integer startDate, Integer endDate) throws Exception {

        // check precondition that customerID is new
        Customer customer = Helper.search(customerList, customerID);
        boolean pre = (customer == null);
        if(!pre) {
            String msg = "ERROR MESSAGE: The customer id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that addressID is new
        Address address = Helper.search(addressList, addressID);
        boolean pre2 = (address == null);
        if(!pre2) {
            String msg = "ERROR MESSAGE: The address id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that orderID is new
        Order order = Helper.search(orderList, orderID);
        boolean pre3 = (order == null);
        if(!pre3) {
            String msg = "ERROR MESSAGE: The order id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that productID exists
        Product product = Helper.search(productList, productID);
        boolean pre4 = (product == null);
        if(pre4) {
            String msg = "ERROR MESSAGE: The product id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // add customer
        customer = new Customer(customerID, name);
        customerList.add(customer);

        // add address
        address = new Address(addressID, line1, line2, contactPerson, contactPhone);
        addressList.add(address);
        customer.addAddress(address);

        // add product
        product = new Product(productID, productDescription);
        productList.add(product);

        // add order
        order = new Order(orderID, customer, address, product, price, quantities, startDate, endDate, "Active");
        orderList.add(order);

    }

    //TODO link address with customer
    // atomic use case 3: Add delivery address to an existing customer
    public void addAddress(String customerID, String addressID, String line1, String line2, String contactPerson, String contactPhone) throws Exception {

        // check precondition that addressID is new
        Address address = Helper.search(addressList, addressID);
        boolean pre = (address == null);
        if( !pre) {
            String msg = "ERROR MESSAGE: The address id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that customerID exists
        Customer customer = Helper.search(customerList, customerID);
        //TODO not working...
        /*boolean pre2 = (customer == null);
        if(pre2) {
            String msg = "ERROR MESSAGE: The customer id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }*/

        // add address
        address = new Address(addressID, line1, line2, contactPerson, contactPhone);
        addressList.add(address);
        //customer.addAddress(address);
    }

    public void addStandingOrder(String orderID,
                                 String customerID, String customerName,
                                 String addressID, String line1, String line2, String contactPerson, String contactPhone,
                                 String productID, String description,
                                 Double price, int[] quantities, Integer startDate, Integer endDate, String status) throws Exception {

        // check precondition that orderID is new
        Order order = Helper.search(orderList, orderID);
        boolean pre = (order == null);
        if( !pre) {
            String msg = "ERROR MESSAGE: The order id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that customerID exists
        Customer customer = Helper.search(customerList, customerID);
        //TODO not working...
        /*boolean pre2 = (customer == null);
        if(pre2) {
            String msg = "ERROR MESSAGE: The customer id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }*/

        // check precondition that productID exists
        Product product = Helper.search(productList, productID);
        //TODO not working...
        /*boolean pre3 = (product == null);
        if(pre3) {
            String msg = "ERROR MESSAGE: The product id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }*/

        customer = new Customer(customerID, customerName);
        Address address = new Address(addressID, line1, line2, contactPerson, contactPhone);
        product = new Product(productID, description);

        // add order
        order = new Order(orderID, customer, address, product, price, quantities, startDate, endDate, status);
        orderList.add(order);
        customer.addOrder(order);
    }

    public void addDelivery(String deliveryID,
                            String customerID, String customerName,
                            String addressID, String line1, String line2, String contactPerson, String contactPhone,
                            Integer date, Integer dayOfWeek,
                            String orderID,
                            String productID, String productDescription,
                            Double price, int[] quantities, Integer startDate, Integer endDate, String status,
                            Integer quantity, Integer difference) throws Exception {

        //TODO checks

        Customer customer = new Customer(customerID, customerName);
        Address address = new Address(addressID, line1, line2, contactPerson, contactPhone);
        Product product = new Product(productID, productDescription);
        Order order = new Order(orderID, customer, address, product, price, quantities, startDate, endDate, status);
        DeliveryItem deliveryItem = new DeliveryItem(order, quantity, difference);

        customerList.add(customer);
        addressList.add(address);
        productList.add(product);
        orderList.add(order);

        //TODO delivery item...
        Delivery delivery = new Delivery(deliveryID, customer, address, date, dayOfWeek);
        deliveryList.add(delivery);
    }
}
