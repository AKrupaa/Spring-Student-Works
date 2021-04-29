package pl.arkadiusz.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource(name = "userSpringSecurityService")
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        dodaj do pamieci springa wbudowanego uzytkownika z uprawnieniami administratora
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("admin@admin.admin").password("{noop}admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("a@a.a").password("{noop}admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("pracownik@pracownik.pracownik").password("{noop}pracownik@pracownik.pracownik").roles("WORKER");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        UTF-8 kodowanie przez ruszeniem zabezpieczń, aby np. hasło z polskim znakiem zostało poprawnie zakodowane :)
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/manageCars*").access("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
                .antMatchers("/add/car").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/delete/car*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/edit/car*").access("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
                .antMatchers("/manageCarType").access("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
                .antMatchers("/add/carType").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/delete/carType*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/edit/carType*").access("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
                .antMatchers("/manageUsers*").access("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
                .antMatchers("/delete/user*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/edit/user*").access("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
                .antMatchers("/add/user*").access("hasRole('ROLE_ADMIN')")

                .antMatchers("/generatePdf-*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_WORKER')")
                .antMatchers("/generate/pdf/*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_WORKER')")
                .antMatchers("/user*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_WORKER')")
                .antMatchers("/info*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_WORKER')")
                .antMatchers("/rental*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_WORKER')")
                .antMatchers("/info/purchase/*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_WORKER')")
                .antMatchers("/purchase/*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_WORKER')")

//                .antMatchers("/manageCars*").access("hasRole('ROLE_USER')")

//                .and().formLogin().permitAll(); // default login page
                .and().formLogin().loginPage("/login").permitAll() // custom login page
                .usernameParameter("email").passwordParameter("password")
                .failureForwardUrl("/login.html?error")
                .successForwardUrl("/welcome/user") // this is post...
                .and().logout().logoutSuccessUrl("/login.html?logout")
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }
}
