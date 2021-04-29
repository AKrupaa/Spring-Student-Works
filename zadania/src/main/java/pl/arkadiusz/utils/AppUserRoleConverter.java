package pl.arkadiusz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.arkadiusz.domain.AppUserRole;
import pl.arkadiusz.service.AppUserRoleService;

import java.util.HashSet;
import java.util.Set;

public class AppUserRoleConverter implements Converter<String, Set<AppUserRole>> {

    private final AppUserRoleService appUserRoleService;

    @Autowired
    public AppUserRoleConverter(AppUserRoleService appUserRoleService) {
        this.appUserRoleService = appUserRoleService;
    }

    @Override
    public Set<AppUserRole> convert(String s) {
        Set<AppUserRole> userRolesList = new HashSet<>(0);
        userRolesList.add(appUserRoleService.getAppUserRole(Integer.parseInt(s)));
        return userRolesList;
    }
}
