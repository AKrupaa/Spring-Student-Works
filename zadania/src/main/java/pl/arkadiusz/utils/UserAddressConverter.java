package pl.arkadiusz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.arkadiusz.domain.UserAddress;
import pl.arkadiusz.service.AddressService;

public class UserAddressConverter implements Converter<String, UserAddress> {

    private final AddressService addressService;

    @Autowired
    public UserAddressConverter(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public UserAddress convert(String s) {
        return addressService.getUserAddress(Integer.parseInt(s));
    }
}
