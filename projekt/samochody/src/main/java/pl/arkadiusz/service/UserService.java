package pl.arkadiusz.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.arkadiusz.domain.UserDomain;

import java.util.List;

public interface UserService {
    @Secured("ROLE_ADMIN")
    UserDomain getUserById(Long id);
    @Secured("ROLE_ADMIN")
    List<UserDomain> getUsers();
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteUserById(Long id);
    void editUser(UserDomain user);
    void addUser(UserDomain user);
}
