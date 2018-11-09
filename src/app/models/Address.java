package app.models;

public class Address {
    private long addressId;
    private int AddressPostcode;
    private String AddressVei;
    private String AddressPostplace;
    private int AddressGatenr;

    public Address(int addressId, int addressPostcode, String addressVei, String addressPostplace, int addressGatenr) {
        this.addressId = addressId;
        AddressPostcode = addressPostcode;
        AddressVei = addressVei;
        AddressPostplace = addressPostplace;
        AddressGatenr = addressGatenr;
    }

    public Address() {
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAddressPostcode() {
        return AddressPostcode;
    }

    public void setAddressPostcode(int addressPostcode) {
        AddressPostcode = addressPostcode;
    }

    public String getAddressVei() {
        return AddressVei;
    }

    public void setAddressVei(String addressVei) {
        AddressVei = addressVei;
    }

    public String getAddressPostplace() {
        return AddressPostplace;
    }

    public void setAddressPostplace(String addressPostplace) {
        AddressPostplace = addressPostplace;
    }

    public int getAddressGatenr() {
        return AddressGatenr;
    }

    public void setAddressGatenr(int addressGatenr) {
        AddressGatenr = addressGatenr;
    }
}
