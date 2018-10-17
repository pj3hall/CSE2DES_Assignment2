public class Address implements SimpleKey {

    private String id;
    private String line1;
    private String line2;
    private String contactPerson;
    private String contactPhone;

    public Address(String id,String line1, String line2, String contactPerson, String contactPhone) {
        this.id = id;
        this.line1 = line1;
        this.line2 = line2;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public String toString() {
        String desc = "Address["
                + "addressID: " + id
                + ", line 1: " + line1
                + ", line 2: " + line2
                + ", contact person: " + contactPerson
                + ", contact phone: " + contactPhone + "]";

        return desc;
    }

    public String getAddressID() {return id;}
    public String getLine1() {return line1;}
    public String getLine2() {return line2;}
    public String getContactPerson() {return contactPerson;}
    public String getContactPhone() {return contactPhone;}

    public String getKey() {return id;}
}
