package pl.arkadiusz.service;

import pl.arkadiusz.domain.UserAuthenticationCoreDomain;

import java.util.List;

public interface UserAuthenticationCoreService {

    void addUserCore(UserAuthenticationCoreDomain userCore);

    void deleteUserCoreById(Long id);

    UserAuthenticationCoreDomain getUserById(Long id);

    UserAuthenticationCoreDomain getUserByEmail(String email);

    List<UserAuthenticationCoreDomain> getUsers();

    void editUserCore(UserAuthenticationCoreDomain user);
}
