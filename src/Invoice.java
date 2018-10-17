import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private String id;
    private Integer fromDate;
    private Integer toDate;
    private Customer customer;
    private List<Delivery> deliveries;
    private Double totalCost; //TODO should be REAL
    private Integer payDate;
    private String status; //TODO status should be issued or paid

    public Invoice(String id, Integer fromDate, Integer toDate, Customer customer, Double totalCost, Integer payDate, String status) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.customer = customer;
        deliveries = new ArrayList<Delivery>();
        this.totalCost = totalCost;
        this.payDate = payDate;
        this.status = status;
    }

    public String toString() {

        // get the set of deliveries for the invoice
        List<String> deliveryIDs = new ArrayList<String>();

        for(Delivery d: deliveries) {
            deliveryIDs.add(d.getDeliveryID());
        }

        String desc = "Invoice["
                + "invoiceID: " + id
                + ", fromDate: " + fromDate
                + ", toDate: " + toDate
                + ", customer: " + customer
                + ", deliveries: " + deliveries
                + ", totalCost: " + totalCost
                + ", payDate: " + payDate
                + ", status: " + status + "]";

        return desc;
    }

    public String getInvoiceID() {return id;}
    public Integer getFromDate() {return fromDate;}
    public Integer getToDate() {return toDate;}
    public Customer getCustomer() {return customer;}
    public List<Delivery> getDeliveries() {return deliveries;}
    public Double getTotalCost() {return totalCost;}
    public Integer getPayDate() {return payDate;}
    public String getStatus() {return status;}

    public void addDelivery(Delivery delivery) throws Exception {
        deliveries.add(delivery);
    }
}
