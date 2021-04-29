package pl.arkadiusz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserAuthenticationCoreDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    //    https://stackoverflow.com/questions/22821695/how-to-fix-hibernate-lazyinitializationexception-failed-to-lazily-initialize-a
    @OneToMany(fetch = FetchType.EAGER)
    Set<HistoryDomain> historyDomains = new HashSet<>(0);
//    @NotNull
//    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;
//    @NotNull
//    @Min(value = 8, message = "Password should not be less than 8 characters")
    @JsonIgnore
    private String password;
    private boolean enabled;

    @OneToOne()
    private UserDomain userDomain;
//    @OneToOne
//    private UserDomain userDomain;
//    @OneToOne(mappedBy = "userAuthenticationCore")
//    private UserDomain userDomain;

//    public UserDomain getUserDomain() {
//        return userDomain;
//    }
//
//    public void setUserDomain(UserDomain userDomain) {
//        this.userDomain = userDomain;
//    }

    //    https://stackoverflow.com/questions/22821695/how-to-fix-hibernate-lazyinitializationexception-failed-to-lazily-initialize-a
    public void addHistory(HistoryDomain historyDomain) {
        this.historyDomains.add(historyDomain);
    }


    native void ciekawe_ciekawe();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<HistoryDomain> getHistoryDomains() {
        return historyDomains;
    }

    public void setHistoryDomains(Set<HistoryDomain> historyDomains) {
        this.historyDomains = historyDomains;
    }

    public UserDomain getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(UserDomain userDomain) {
        this.userDomain = userDomain;
    }


    //    public UserDomain getUserDomain() {
//        return userDomain;
//    }
//
//    public void setUserDomain(UserDomain userDomain) {
//        this.userDomain = userDomain;
//    }
}
