package app.interfaces;

import app.models.Customer;

import java.util.List;

public interface DAOCustomerInterface {

    List<Customer> findAll();
    boolean deleteCustomer(Customer customer);
    boolean changeCustomer(Customer customer);
    boolean addCustomer(Customer customer);


}






