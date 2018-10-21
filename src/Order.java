import java.util.*;

public class Order implements SimpleKey {

    public enum ORDERSTATUS{active, closed}

    private String id;
    private Customer customer;
    private Address address;
    private Product product;
    private Double price; //TODO what is REAL?
    private int[] quantities;
    private Integer startDate;
    private Integer endDate;
    private ORDERSTATUS status;

    public Order(String id, Customer customer, Address address, Product product, Double price,
                 int[] quantities, Integer startDate, Integer endDate, ORDERSTATUS status) {

        this.id = id;
        this.customer = customer;
        this.address = address;
        this.product = product;
        this.price = price;
        this.quantities = quantities;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        //this.customer.addOrder(); //TODO lab 7 adds permit from here. Do I add order, address, product?
    }

    public String toString() {
        String desc = "Order["
                + "orderID: " + id
                + ", customer: " + customer.getName() + "(id: " + customer.getCustomerID() + ")"
                + ", address: " + address.getAddressID()
                + ", product: " + product.getProductID()
                + ", price: " + price
                + ", quantities: " + Arrays.toString(quantities)
                + ", start date: " + startDate
                + ", end date: " + endDate
                + ", status: " + status + "]";

        return desc;
    }

    public static Comparator<Order> CustomerCom = new Comparator<Order>() {
        public int compare(Order o1, Order o2) {
            String customerName1 = o1.getCustomer().getName().toUpperCase();
            String customerName2 = o2.getCustomer().getName().toUpperCase();
            String customerID1 = o1.getCustomer().getCustomerID().toUpperCase();
            String customerID2 = o2.getCustomer().getCustomerID().toUpperCase();

            int c = customerName1.compareTo(customerName2);
            if (c == 0) {
                c = customerID1.compareTo(customerID2);
            }
            return c;
        }
    };

    public String getOrderID() {return id;}
    public Customer getCustomer() {return customer;}
    public Address getAddress() {return address;}
    public Product getProduct() {return product;}
    public Double getPrice() {return price;}
    public int[] getQuantities() {return quantities;}
    public Integer getStartDate() {return startDate;}
    public Integer getEndDate() {return endDate;}
    public ORDERSTATUS getStatus() {return status;}

    public String getKey() {return id;}
}
