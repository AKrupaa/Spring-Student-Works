package pl.arkadiusz.service;

import pl.arkadiusz.domain.AppUserRole;

import java.util.List;

public interface AppUserRoleService {
    void addAppUserRole(AppUserRole appUserRole);
    List<AppUserRole> listAppUserRoles();
    AppUserRole getAppUserRole(long id);
}
