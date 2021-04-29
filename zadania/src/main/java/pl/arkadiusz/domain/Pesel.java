package pl.arkadiusz.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Pesel {
    @Column(name = "pesel")
    String PESEL;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @OneToOne(mappedBy = "pesel")
    private AppUser appUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }


}
