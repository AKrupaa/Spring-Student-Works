package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://stackoverflow.com/questions/22821695/how-to-fix-hibernate-lazyinitializationexception-failed-to-lazily-initialize-a
@Transactional
@Service("userSpringSecurityService")
public class UserSpringSecurityService implements UserDetailsService {

    UserAuthenticationCoreService service;

    @Autowired
    public UserSpringSecurityService(UserAuthenticationCoreService userAuthenticationCoreService) {
        this.service = userAuthenticationCoreService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAuthenticationCoreDomain userCore = service.getUserByEmail(s);
        List<GrantedAuthority> authorities = buildUserAuthority("ROLE_USER");
        return buildUserForAuthentication(userCore, authorities);
    }

    private User buildUserForAuthentication(UserAuthenticationCoreDomain userCore, List<GrantedAuthority> authorities) {

        return new User(userCore.getEmail(), userCore.getPassword(), userCore.isEnabled(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(String HERE_USER_ROLE) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SUPER_USER"));
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        grantedAuthorities.add(new SimpleGrantedAuthority(HERE_USER_ROLE)); // as default == ROLE_USER
        List<GrantedAuthority> result = new ArrayList<>(grantedAuthorities);

        return result;
    }
}
