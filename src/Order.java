import java.rmi.activation.ActivationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order implements SimpleKey {

    private String id;
    private Customer customer;
    private Address address;
    private Product product;
    private Double price; //TODO what is REAL?
    private int[] quantities;
    private Integer startDate;
    private Integer endDate;
    private String status; //TODO how to reference active and closed

    public Order(String id, Customer customer, Address address, Product product, Double price,
                 int[] quantities, Integer startDate, Integer endDate, String status) {

        this.id = id;
        this.customer = customer;
        this.address = address;
        this.product = product;
        this.price = price;
        this.quantities = quantities;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        //this.status = ACTIVE;
        //this.customer.addOrder(); //TODO lab 7 adds permit from here. Do I add order, address, product?
    }

    public String toString() {
        String desc = "Order["
                + "orderID: " + id
                + ", customer: " + customer.getCustomerID()
                + ", address: " + address.getAddressID()
                + ", product: " + product.getProductID()
                + ", price: " + price
                + ", quantities: " + Arrays.toString(quantities)
                + ", start date: " + startDate
                + ", end date: " + endDate
                + ", status: " + status + "]";

        return desc;
    }

    public String getOrderID() {return id;}
    public Customer getCustomer() {return customer;}
    public Address getAddress() {return address;}
    public Product getProduct() {return product;}
    public Double getPrice() {return price;} //TODO Real
    public int[] getQuantities() {return quantities;}
    public Integer getStartDate() {return startDate;}
    public Integer getEndDate() {return endDate;}
    public String getStatus() {return status;}

    public String getKey() {return id;}
}
