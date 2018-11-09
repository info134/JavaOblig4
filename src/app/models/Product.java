package app.models;

public class Product {
    private int pID;
    private String pName;
    private String description;
    private int price;
    private int category;

    public Product(int pID, String pName, String description, int price, int category) {
        this.pID = pID;
        this.pName = pName;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product() {

    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
