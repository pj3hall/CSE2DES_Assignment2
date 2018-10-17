public class Product implements SimpleKey {

    private String id;
    private String description;

    public Product(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String toString() {
        String desc = "Product["
                + "productID: " + id
                + ", description: " + description + "]";

        return desc;
    }

    public String getProductID() {return id;}
    public String getDescription() {return description;}

    public String getKey() {return id;}
}
