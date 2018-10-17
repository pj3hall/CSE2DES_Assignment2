import java.util.List;
import java.util.ArrayList;

public class Customer implements SimpleKey {

    private String id;
    private String name;
    private Address address; //TODO not sure
    private Order order; //TODO not sure
    private List<Address> addresses;
    private List<Order> orders;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        addresses = new ArrayList<Address>();
        orders = new ArrayList<Order>();
    }

    public String toString() {

        // get the set of addresses for the customer
        List<String> addressIDs = new ArrayList<String>();
        for(Address a: addresses) {
            addressIDs.add(a.getAddressID());
        }

        // get the set of orders for the customer
        List<String> orderIDs = new ArrayList<String>();
        for(Order o: orders) {
            orderIDs.add(o.getOrderID());
        }

        // form the customer's description
        String desc = "Customer["
                + "customerID: " + id
                + ", name: " + name
                + ", addresses: " + addressIDs
                + ", orders: " + orderIDs + "]";

        return desc;
    }

    public String getKey() {
        return id;
    }

    public String getCustomerID() {return id;}
    public String getName() {return name;}
    public List<Address> getAddresses() {return addresses;}
    public List<Order> getOrders() {return orders;}

    public void addAddress(Address address) throws Exception {
        addresses.add(address);
    }

    public void addOrder(Order order) throws Exception {
        orders.add(order);
    }
}
