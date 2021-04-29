package pl.arkadiusz.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String firstName;
    private String lastName;
    private String telephone;

//    @OneToOne(cascade = CascadeType.ALL)
//    private UserAuthenticationCoreDomain userAuthenticationCore;

//    @OneToMany()
//    Set<CarDomain> carDomains;

//    public Set<CarDomain> getCarDomains() {
//        return carDomains;
//    }

//    public void setCarDomains(Set<CarDomain> carDomains) {
//        this.carDomains = carDomains;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

//    public UserAuthenticationCoreDomain getUserAuthenticationCore() {
//        return userAuthenticationCore;
//    }
//
//    public void setUserAuthenticationCore(UserAuthenticationCoreDomain userAuthenticationCore) {
//        this.userAuthenticationCore = userAuthenticationCore;
//    }
}
