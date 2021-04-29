package pl.arkadiusz.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "UserAddress")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @OneToMany(mappedBy = "userAddress")
//    private List<AppUser> appUserList;

    @NotNull
    @Column(name = "address")
    private String address;
    //private String street;
    @NotNull
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "{error.valid.zipcode}")
    @Column(name = "zipCode")
    private String zipCode;
    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "city")
    private String city;
    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "country")
    private String country;
    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "state")
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public List<AppUser> getAppUserList() {
//        return appUserList;
//    }

//    public void setAppUserList(List<AppUser> appUserList) {
//        this.appUserList = appUserList;
//    }
}
