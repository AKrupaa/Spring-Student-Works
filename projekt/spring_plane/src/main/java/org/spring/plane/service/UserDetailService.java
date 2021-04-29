package org.spring.plane.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.spring.plane.domain.CustomUserDomain;
import org.spring.plane.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("userSpringSecurityService")
public class UserDetailService implements UserDetailsService {

    private final CustomUserService customUserService;

    @Autowired
    public UserDetailService(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {

        CustomUserDomain customUserDomain = customUserService.findByLogin(login);
        List<GrantedAuthority> authorities = buildUserAuthority(customUserDomain.getUserRoles());
        return buildUserForAuthentication(customUserDomain, authorities);
    }

    // Converts AppUser user to org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(CustomUserDomain customUserDomain, List<GrantedAuthority> authorities) {

        return new User(customUserDomain.getLogin(), customUserDomain.getPassword(), customUserDomain.isEnabled(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> appUserRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // Build user's authorities
        for (UserRole appUserRole : appUserRoles) {
            setAuths.add(new SimpleGrantedAuthority(appUserRole.getRole()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }
}

