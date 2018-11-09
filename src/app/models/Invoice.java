package app.models;
import java.util.List;

public class Invoice {
    private int customer;
    private List<Product> products;
    private Address address;
    private int addressPostcode;
    private int invoiceID;
    private String invoiceDate;
    private String customerBetalttil;
    private String customerBelastk;

    public Invoice(int customer, Address address, String customerBetalttil, String customerBelastk
            , int addressPostcode) {
        this.customer = customer;
        this.customerBetalttil = customerBetalttil;
        this.customerBelastk = customerBelastk;
        this.address = address;
        this.addressPostcode = addressPostcode;
    }

    public Invoice() {

    }


    public String getCustomerBelastk() {
        return customerBelastk;
    }

    public void setCustomerBelastk(String customerBelastk) {
        this.customerBelastk = customerBelastk;
    }

    public String getCustomerBetalttil() {
        return customerBetalttil;
    }

    public void setCustomerBetalttil(String customerBetalttil) {
        this.customerBetalttil = customerBetalttil;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getInvoiceID() {
        return invoiceID;
    }


    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(int addressPostcode) {
        this.addressPostcode = addressPostcode;
    }
}

