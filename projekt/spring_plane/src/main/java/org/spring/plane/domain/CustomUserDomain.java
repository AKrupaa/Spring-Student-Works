package org.spring.plane.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CustomUserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    //    @NotEmpty(message = "{error.field.required}")
//    @Min(value = 5, message = "error.min.five")
    private String firstName;

    //    @NotEmpty(message = "{error.field.required}")
//    @Min(value = 5, message = "error.min.five")
    private String lastName;
//    @Min(value = 5, message = "error.min.five")
    private String email;

    @Column(unique = true)
//    @NotEmpty(message = "{error.field.required}")
//    @Min(value = 5, message = "error.min.five")
    private String login;
    @JsonIgnore
//    @NotEmpty(message = "{error.field.required}")
//    @Min(value = 5, message = "error.min.five")
    private String password;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>(0);

    @OneToMany
    private Set<Ticket> tickets = new HashSet<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}

