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

    @Resource(name = "myAppUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN", "USER");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("student").password("{noop}student").roles("STUDENT");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/appUsers*").access("hasRole('ADMIN')")
                .antMatchers("/appUserRole*").access("hasRole('ADMIN')")
                .antMatchers("/exampleOne*").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/exampleTwo*").access("hasRole('STUDENT')")
                .antMatchers("/exampleThree*").access("hasRole('USER')")
//                .and().formLogin().permitAll(); // this is for default login page
                .and().formLogin().loginPage("/login").permitAll() // custom login page
                .usernameParameter("login").passwordParameter("password")
                .failureForwardUrl("/login.html?error")
                .and().logout().logoutSuccessUrl("/login.html?logout")
                .and().exceptionHandling().accessDeniedPage("/accessDenied");

    }
}
