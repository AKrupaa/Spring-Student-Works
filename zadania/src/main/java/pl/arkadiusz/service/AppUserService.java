package pl.arkadiusz.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.arkadiusz.domain.AppUser;

import java.util.List;

public interface AppUserService {
    @Secured("ROLE_ADMIN")
    public void addAppUser(AppUser user);
//    # ? co to jest
    @PreAuthorize("hasRole('ROLE_ADMIN') OR (#appUser.login == principal.username)")
    public void editAppUser(AppUser user);
    public List<AppUser> listAppUser();
    @Secured("ROLE_ADMIN")
    public void removeAppUser (long id);
    public AppUser getAppUser(long id);
    AppUser findByLogin(String login);
}
