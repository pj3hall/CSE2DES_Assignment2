import java.util.ArrayList;
import java.util.List;

public class Delivery implements SimpleKey {

    private String id;
    private Customer customer;
    private Address address;
    private Integer date;
    private Integer dayOfWeek;
    private DeliveryItem deliveryItem; //TODO not sure
    private List<DeliveryItem> deliveryItems;

    //TODO calculate dayOfWeek
    public Delivery(String id, Customer customer, Address address, Integer date, Integer dayOfWeek) {
        this.id = id;
        this.customer = customer;
        this.address = address;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        deliveryItems = new ArrayList<DeliveryItem>();
    }

    public String toString() {

        // get the set of deliveryItems for the delivery
        List<Order> orders = new ArrayList<Order>();

        for(DeliveryItem i: deliveryItems) {
            orders.add(i.getOrder());
        }

        String desc = "Delivery["
                + "deliveryID: " + id
                + ", customer: " + customer.getCustomerID()
                + ", address: " + address.getAddressID()
                + ", date: " + date
                + ", dayOfWeek: " + dayOfWeek
                + ", deliveryItems: " + orders + "]";

        return desc;
    }

    public String getKey() {
        return id;
    }

    public String getDeliveryID() {return id;}
    public Customer getCustomer() {return customer;}
    public Address getAddress() {return address;}
    public Integer getDate() {return date;}
    public Integer getDayOfWeek() {return dayOfWeek;}
    public List<DeliveryItem> getDeliveryItems() {return deliveryItems;}

    public void addDeliveryItem(DeliveryItem deliveryItem) throws Exception {
        deliveryItems.add(deliveryItem);
    }
}
