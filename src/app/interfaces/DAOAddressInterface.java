package app.interfaces;


import app.DAOs.DAOAddress;
import app.models.Address;

import java.util.List;

public interface DAOAddressInterface {


    List<Address> findAll();
    boolean deleteAddress(Address address);
    boolean changeAddress(Address address);
    boolean addAddress(Address address);



}

