package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.dao.AppUserRoleRepository;
import pl.arkadiusz.domain.AppUserRole;

import java.util.List;

@Service("appUserRoleService")
@Transactional
public class AppUserRoleServiceImpl implements AppUserRoleService {

    private AppUserRoleRepository appUserRoleRepository;

    @Autowired
    public AppUserRoleServiceImpl(AppUserRoleRepository appUserRoleRepository) {
        this.appUserRoleRepository = appUserRoleRepository;
    }

    public void addAppUserRole(AppUserRole appUserRole) {
        appUserRoleRepository.save(appUserRole);
    }

    public List<AppUserRole> listAppUserRoles() {
        return appUserRoleRepository.findAll();
    }

    public AppUserRole getAppUserRole(long id) {
        return appUserRoleRepository.getOne(id);
    }
}
