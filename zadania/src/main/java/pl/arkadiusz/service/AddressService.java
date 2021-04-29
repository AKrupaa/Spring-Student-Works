package pl.arkadiusz.service;

import pl.arkadiusz.domain.UserAddress;

import java.util.List;

public interface AddressService {
    public void addAddress(UserAddress userAddress);
    public void editAppUser(UserAddress userAddress);
    public UserAddress getUserAddress(long id);
    public UserAddress removeUserAddress(long id);
    public List<UserAddress> getUsersAddresses();
}
