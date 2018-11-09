package app.models;

public class Customer {

    private int id;
    private String name;
    private Address address;
    private int PhoneNr;
    private long BillingAcc;

    public Customer(int id, String name, int phoneNr, long billingAcc) {
        this.id = id;
        this.name = name;
        this.address = address;
        PhoneNr = phoneNr;
        BillingAcc = billingAcc;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPhoneNr() {
        return PhoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        PhoneNr = phoneNr;
    }

    public long getBillingAcc() {
        return BillingAcc;
    }

    public void setBillingAcc(long billingAcc) {
        BillingAcc = billingAcc;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
