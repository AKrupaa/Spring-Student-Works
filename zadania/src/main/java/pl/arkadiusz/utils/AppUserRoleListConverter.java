package pl.arkadiusz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.arkadiusz.domain.AppUserRole;
import pl.arkadiusz.service.AppUserRoleService;

import java.util.HashSet;
import java.util.Set;

public class AppUserRoleListConverter implements Converter<String[], Set<AppUserRole>> {

    private AppUserRoleService appUserRoleService;

    @Autowired
    public AppUserRoleListConverter(AppUserRoleService appUserRoleService) {
        this.appUserRoleService = appUserRoleService;
    }

    @Override
    public Set<AppUserRole> convert(String[] strings) {
        Set<AppUserRole> userRolesList = new HashSet<>(0);

        for (int i = 0; i < strings.length; i++) {
            userRolesList.add(appUserRoleService.getAppUserRole(Integer.parseInt(strings[i])));
        }

        return userRolesList;
    }
}
