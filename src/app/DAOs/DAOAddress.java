package app.DAOs;
import app.DatabaseAdapter;
import app.interfaces.DAOAddressInterface;
import app.models.Address;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DAOAddress implements DAOAddressInterface {
    private DatabaseAdapter data = DatabaseAdapter.getInstance();

    public List<Address> findAll() {
        {
            List<Address> result = new ArrayList<>();
            try {
                PreparedStatement prep2 = data.theConnection().prepareStatement("SELECT * FROM address");
//                + " JOIN customer WHERE address.address_id = customer.address");
                ResultSet res2 = prep2.executeQuery();

                while (res2.next()) {
                    // fetch fields from result:
                    String postcode = (res2.getString("postal_code"));
                    String vei = (res2.getString("street_name"));
                    String postplace = (res2.getString("postal_town"));
                    String gatenr = (res2.getString("street_number"));
                    String addressID = res2.getString("address_id");

                    // create new address object:
                    Address address = new Address();
                    address.setAddressGatenr(Integer.valueOf(gatenr));
                    address.setAddressPostcode(Integer.valueOf(postcode));
                    address.setAddressPostplace(postplace);
                    address.setAddressVei(vei);
                    address.setAddressId(Integer.valueOf(addressID));
                    result.add(address);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public boolean deleteAddress(Address address) {
        try {
            PreparedStatement delete = data.theConnection().prepareStatement("DELETE FROM address WHERE address_id=?");
            delete.setLong(1, address.getAddressId());
            System.out.println("address is: " + address.getAddressId());
            PreparedStatement delCat = data.theConnection().prepareStatement("DELETE FROM category WHERE category_id= ?");
            delCat.setLong(1, address.getAddressId());
            PreparedStatement delInvoiceItem = data.theConnection().prepareStatement("DELETE FROM invoice_items WHERE invoice_items.product= ?");
            delInvoiceItem.setLong(1, address.getAddressId());
            delInvoiceItem.executeUpdate();
            delCat.executeUpdate();
            delete.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeAddress(Address address) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("UPDATE address SET street_name=?, street_number=?, address_id =?, postal_code=?, postal_town =? WHERE address_id= ?");
            change.setString(1, address.getAddressVei());
            change.setInt(2, address.getAddressGatenr());
            change.setLong(3, address.getAddressId());
            change.setInt(4, address.getAddressPostcode());
            change.setString(5, address.getAddressPostplace());
            change.setLong(6, address.getAddressId());
            change.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addAddress(Address address) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("INSERT INTO address (street_name, street_number,address_id, postal_code, postal_town)" +
                    "VALUES (?, ?, ?, ?, ?)");
            change.setString(1, address.getAddressVei());
            change.setInt(2, address.getAddressGatenr());
            change.setLong(3, address.getAddressId());
            change.setInt(4, address.getAddressPostcode());
            change.setString(5, address.getAddressPostplace());
            change.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
