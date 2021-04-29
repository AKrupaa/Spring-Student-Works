package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arkadiusz.dao.AddressRepository;
import pl.arkadiusz.domain.UserAddress;

import javax.transaction.Transactional;
import java.util.List;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(UserAddress userAddress) {
        addressRepository.save(userAddress);
    }

    public void editAppUser(UserAddress userAddress) {
        addressRepository.save(userAddress);
    }

    public UserAddress getUserAddress(long id) {
        return addressRepository.findById(id);
    }

    public UserAddress removeUserAddress(long id) {
        UserAddress userAddress = addressRepository.findById(id);
        addressRepository.delete(id);
        return userAddress;
    }

    public List<UserAddress> getUsersAddresses() {
        return addressRepository.findAll();
    }
}
