package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.arkadiusz.domain.UserAddress;
import pl.arkadiusz.service.AddressService;
import pl.arkadiusz.validator.AddressValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AddressController {
    private long editedUser = -1;

    private final AddressService addressService;
    private AddressValidator addressValidator = new AddressValidator();

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // add a Address to database
    // you are waiting for POST to do this at /addUserAddress URI address.
    @RequestMapping(value = "/addUserAddress", method = RequestMethod.POST)
    public String addUserAddress(@Valid @ModelAttribute("modelUserAddress") UserAddress userAddress, BindingResult result, Model model) {

        // print what you got
        System.out.println(
                " Country:" + userAddress.getCountry()
                        + " City:" + userAddress.getCity()
                        + " State:" + userAddress.getState()
                        + " Zip:" + userAddress.getZipCode()
                        + " Address:" + userAddress.getAddress()
        );

        addressValidator.validate(userAddress, result);
        if(result.getErrorCount() == 0) {
            // add those to database.
            if (userAddress.getId() == 0)
                addressService.addAddress(userAddress);
            else if (userAddress.getId() > 0)
                addressService.editAppUser(userAddress);
            return "redirect:userAddressView";
        }
        // jak nie zwaliduje poprawnie to zwroc do strony internetowej liste uzytkownikow
        model.addAttribute("modelListOfUsersAddresses", addressService.getUsersAddresses());
        // przejdz ponownie do tej strony internetowej.
        return "userAddressView";
    }


    // let delete some
    @RequestMapping(value = "/deleteAddress/{userAddressID}")
    public String deleteUserAddress(@PathVariable(value = "userAddressID") long userAddressID) {

        // pop, you can do whatever you want with old one or forget about it ;)
        UserAddress userAddress = addressService.removeUserAddress(userAddressID);

        return "redirect:/userAddressView.html";
    }


    @RequestMapping(value = "/showUserAddress/{userAddressID}")
    public String showUserAddress(@PathVariable(value = "userAddressID") long userAddressID/*,
                                  Model model*/) {

        // if there is nothing to show, return a new UserAddress otherwise show details of ... ID
//        if (userAddressID > 0)
//            model.addAttribute("modelUserAddress", addressService.getUserAddress(userAddressID));
//        else
//            model.addAttribute("modelUserAddress", new UserAddress());
//        model.addAttribute("modelListOfUsersAddresses", addressService.getUsersAddresses());

        editedUser = userAddressID;

        return "redirect:/userAddressView.html";
    }


    @RequestMapping(value = "/userAddressView")
    public String showPageUserAddress(Model model) {

        if (editedUser > 0)
            model.addAttribute("modelUserAddress", addressService.getUserAddress(editedUser));
        else
            model.addAttribute("modelUserAddress", new UserAddress());
//        model.addAttribute("modelUserAddress", new UserAddress());
        model.addAttribute("modelListOfUsersAddresses", addressService.getUsersAddresses());
        editedUser = -1;
        return "userAddressView";
    }
}
