package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.domain.AppUser;
import pl.arkadiusz.domain.AppUserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// serwis UserDetailsService jest od spring security, zawiera Usera i tam trzeba podac dane naszego appUsera
@Service("myAppUserDetailsService")
@Transactional
public class MyAppUserDetailsService implements UserDetailsService {

    AppUserService appUserService;

    @Autowired
    public MyAppUserDetailsService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    private User buildUserForAuthentication(AppUser appUser, List<GrantedAuthority> authorities) {
        return new User(appUser.getLogin(), appUser.getPassword(), appUser.isEnabled(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<AppUserRole> appUserRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();

        for (AppUserRole appUserRole : appUserRoles) {
            setAuths.add(new SimpleGrantedAuthority(appUserRole.getRole()));
        }

        List<GrantedAuthority> result = new ArrayList<>(setAuths);
        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(appUser.getAppUserRole());
        return buildUserForAuthentication(appUser, authorities);
    }
}
