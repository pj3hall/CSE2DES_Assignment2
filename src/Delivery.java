import java.util.ArrayList;
import java.util.List;

public class Delivery {

    private String id;
    private Customer customer;
    private Address address;
    private Integer date;
    private Integer dayOfWeek;
    private List<DeliveryItem> deliveryItems;

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
                + ", customer: " + customer
                + ", address: " + address
                + ", date: " + date
                + ", dayOfWeek: " + dayOfWeek
                + ", deliveryItems: " + deliveryItems + "]";

        return desc;
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
