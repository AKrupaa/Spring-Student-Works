package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.arkadiusz.dao.AppUserRepository;
import pl.arkadiusz.dao.AppUserRoleRepository;
import pl.arkadiusz.domain.AppUser;

import javax.transaction.Transactional;
import java.util.List;

// wskazujemy, ze jest to serwis

@Service("appUserService")
@Transactional
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserRoleRepository appUserRoleRepository;

    // konstruktor
    // dependency injection
    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, AppUserRoleRepository appUserRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appUserRoleRepository = appUserRoleRepository;
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public void addAppUser(AppUser user) {
        user.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
        user.setPassword(hashPassword(user.getPassword()));
        AppUser temp = appUserRepository.findByLogin(user.getLogin());
        if (temp == null)
            appUserRepository.save(user);
    }

    public void editAppUser(AppUser user) {
        if (!user.getPassword().equals(appUserRepository.findById(user.getId()).getPassword())) {
            user.setPassword(hashPassword(user.getPassword()));
//            System.out.println("\n\nINNE HASLO!\n\n");

        } else {
//            System.out.println("\n\nHASLO TAKIE SAMO!\n\n");
            user.setPassword(user.getPassword());
        }
        user.setAppUserRole(appUserRepository.findById(user.getId()).getAppUserRole());
        appUserRepository.save(user);
    }

    public List<AppUser> listAppUser() {
        return appUserRepository.findAll();
    }

    public void removeAppUser(long id) {
        appUserRepository.delete(id);
    }

    public AppUser getAppUser(long id) {
        return appUserRepository.findById(id);
//        return null;
    }

    @Override
    public AppUser findByLogin(String login) {
        return appUserRepository.findByLogin(login);
    }
}
