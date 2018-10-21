import java.util.*;

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

    // atomic use case 2: Add new customer with one delivery address
    public void addCustomer(String customerID, String name, Address address) throws Exception {

        // get address information
        String addressID = address.getAddressID();
        String line1 = address.getLine1();
        String line2 = address.getLine2();
        String contactPerson = address.getContactPerson();
        String contactPhone = address.getContactPhone();

        // check precondition that customerID is new
        Customer customer = Helper.search(customerList, customerID);
        boolean pre = (customer == null);
        if(!pre) {
            String msg = "ERROR MESSAGE: The customer id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that addressID is new
        address = Helper.search(addressList, addressID);
        boolean pre2 = (address == null);
        if(!pre2) {
            String msg = "ERROR MESSAGE: The address id already exists.";
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

    }

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
        boolean pre2 = (customer == null);
        if(pre2) {
            String msg = "ERROR MESSAGE: The customer id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // add address
        address = new Address(addressID, line1, line2, contactPerson, contactPhone);
        addressList.add(address);
        customer.addAddress(address);
    }

    public void addStandingOrder(String orderID, Customer customer, Address address, Product product,
                                 Double price, int[] quantities, Integer startDate, Integer endDate, Order.ORDERSTATUS status) throws Exception {

        // get customer information
        String customerID = customer.getCustomerID();
        String customerName = customer.getName();

        // get address information
        String addressID = address.getAddressID();
        String line1 = address.getLine1();
        String line2 = address.getLine2();
        String contactPerson = address.getContactPerson();
        String contactPhone = address.getContactPhone();

        // get product information
        String productID = product.getProductID();
        String description = product.getDescription();

        // check precondition that orderID is new
        Order order = Helper.search(orderList, orderID);
        boolean pre = (order == null);
        if( !pre) {
            String msg = "ERROR MESSAGE: The order id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that customerID exists
        customer = Helper.search(customerList, customerID);
        boolean pre2 = (customer == null);
        if(pre2) {
            String msg = "ERROR MESSAGE: The customer id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that productID exists
        product = Helper.search(productList, productID);
        boolean pre3 = (product == null);
        if(pre3) {
            String msg = "ERROR MESSAGE: The product id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        customer = new Customer(customerID, customerName);
        address = new Address(addressID, line1, line2, contactPerson, contactPhone);
        product = new Product(productID, description);

        // add order
        order = new Order(orderID, customer, address, product, price, quantities, startDate, endDate, status);
        orderList.add(order);
        customer.addOrder(order);
    }

    public void listStandingOrders() throws Exception {

        //TODO add date
        Collections.sort(orderList, Order.CustomerCom);

        for (Order o: orderList) {
            System.out.println(o);
        }
    }

    public void addDelivery(String deliveryID, Customer customer, Address address, Integer date, Integer dayOfWeek, String orderID, Product product, Double price, int[] quantities, Integer startDate, Integer endDate, Order.ORDERSTATUS status, Integer quantity, Integer difference) throws Exception {

        // get customer information
        String customerID = customer.getCustomerID();
        String customerName = customer.getName();

        // get address information
        String addressID = address.getAddressID();
        String line1 = address.getLine1();
        String line2 = address.getLine2();
        String contactPerson = address.getContactPerson();
        String contactPhone = address.getContactPhone();

        // get product information
        String productID = product.getProductID();
        String description = product.getDescription();

        // check precondition that deliveryID is new
        Delivery delivery = Helper.search(deliveryList, deliveryID);
        boolean pre = (delivery == null);
        if( !pre) {
            String msg = "ERROR MESSAGE: The delivery id already exists.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that customerID exists
        customer = Helper.search(customerList, customerID);
        boolean pre2 = (customer == null);
        if(pre2) {
            String msg = "ERROR MESSAGE: The customer id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        // check precondition that addressID exists
        address = Helper.search(addressList, addressID);
        boolean pre3 = (address == null);
        if(pre3) {
            String msg = "ERROR MESSAGE: The address id doesn't exist.";
            System.out.println(msg);
            throw new Exception(msg);
        }

        customer = new Customer(customerID, customerName);
        address = new Address(addressID, line1, line2, contactPerson, contactPhone);
        product = new Product(productID, description);
        Order order = new Order(orderID, customer, address, product, price, quantities, startDate, endDate, status);

        delivery = new Delivery(deliveryID, customer, address, date, dayOfWeek);
        deliveryList.add(delivery);

        DeliveryItem deliveryItem = new DeliveryItem(order, quantity, difference);
        delivery.addDeliveryItem(deliveryItem);
    }
}
