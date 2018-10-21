public class DeliveryItem implements SimpleKey {

    private Order order;
    private Integer quantity;
    private Integer difference;

    public DeliveryItem(Order order, Integer quantity, Integer difference) {
        this.order = order;
        this.quantity = quantity;
        this.difference = difference;
    }

    public String toString() {
        String desc = "DeliveryItem["
                + "order: " + order.getOrderID()
                + "product: " + order.getProduct()
                + ", quantity: " + quantity
                + ", difference: " + difference + "]";

        return desc;
    }

    public String getKey() {return order.getOrderID();}

    public Order getOrder() {return order;}
    public Integer getQuantity() {return quantity;}
    public Integer getDifference() {return difference;}

    //TODO calculate difference
}
