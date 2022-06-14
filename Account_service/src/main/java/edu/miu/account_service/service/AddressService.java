package edu.miu.account_service.service;

import edu.miu.account_service.domain.Address;

import java.util.List;

public interface AddressService {
    public Address saveAddress(Address address);
    public List<Address> getAllAdresses();

}
