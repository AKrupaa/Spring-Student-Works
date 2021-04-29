package pl.arkadiusz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "appuser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    //    propagates all operations — including Hibernate-specific ones — from a parent to a child entity
    @OneToOne(cascade = CascadeType.ALL)
//    @Pattern(regexp = "\\d{11}", message = "{error.valid.pesel}")
//    @NotEmpty(message = "Please enter pesel")
    @JsonManagedReference
    private Pesel pesel;

    @ManyToOne
    private UserAddress userAddress;

    @NotNull
    @Column(unique = true)
    private String login;

    @JsonIgnore
    @NotNull
    private String password;

    private boolean enabled;

    @NotNull
    @Column(name = "firstName", nullable = false)
    @Size(min = 2, max = 30, message = "{error.size.firstName}")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "lastName")
    private String lastName;
    @NotNull
//    @Size(min = 2,max = 30)
    @Column(name = "email")
    private String email;
    //    @NotNull
//    @Size(min = 11,max = 11)
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}", message = "{error.valid.telephone}")
    @Column(name = "telephone")
    private String telephone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public void setPesel(Pesel pesel) {
        this.pesel = pesel;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}
