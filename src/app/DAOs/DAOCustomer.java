package app.DAOs;

import app.DatabaseAdapter;
import app.interfaces.DAOCustomerInterface;
import app.models.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCustomer implements DAOCustomerInterface {

    private DatabaseAdapter data = DatabaseAdapter.getInstance();

    public List<Customer> findAll() {
        List<Customer> result = new ArrayList<>();

        try {
            PreparedStatement prep = data.theConnection().prepareStatement("SELECT *" +
                            " FROM customer"
//                +    " JOIN address on customer.address = address.address_id;"
            );

            ResultSet res = prep.executeQuery();
            while (res.next()) {
                int customerKid = (res.getInt("customer_id"));
                String customerName = (res.getString("customer_name"));
                int customerPhone = (res.getInt("phone_number"));
                long customerBelastk = (res.getLong("billing_account"));
                result.add(new Customer(customerKid, customerName, customerPhone, customerBelastk));
            }
//            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean changeCustomer(Customer customer) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("UPDATE customer SET customer_name=?, phone_number=?,billing_account=? WHERE customer_id=?");
            change.setString(1, customer.getName());
            change.setInt(2, customer.getPhoneNr());
            change.setLong(3, customer.getBillingAcc());
            change.setInt(4, customer.getId());
            change.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addCustomer(Customer customer) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("INSERT INTO customer (customer_name, phone_number,billing_account)" +
                    "VALUES (?, ?, ?)");
            change.setString(1, customer.getName());
            change.setInt(2, customer.getPhoneNr());
            change.setLong(3, customer.getBillingAcc());
            change.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(Customer customer) {
        try {
            PreparedStatement delete = data.theConnection().prepareStatement("DELETE FROM customer WHERE customer_id=?");
            delete.setInt(1, customer.getId());
            delete.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return false;
    }

}
