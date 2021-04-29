package org.spring.plane.configuration;

import org.spring.plane.service.UserRoleService;
import org.spring.plane.utils.ModelRoleConverter;
import org.spring.plane.utils.ModelRolesConverter;
import org.spring.plane.utils.ModelRolesListConverter;
import org.spring.plane.utils.UserRoleToStringConverter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import javax.annotation.Resource;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("org.spring.plane")
public class SpringConfiguration implements WebMvcConfigurer {

    @Resource(name = "userRoleService")
    private UserRoleService userRoleService;

    // Configure TilesConfigurer.
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("tilesConfiguration/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    // Configure InternalResourceViewResolver.
    /* @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    } */

    // Configure ViewResolvers to deliver preferred views.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    // Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    //    Configure message (language i18n) source directory
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/resources/i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    //    Configure LocaleResolver with default locale as 'en'
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    //    Configure interceptor to switch language when 'lang' parameter found in request
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    //    configure validator bean to read error codes from properties (language) files
    @Bean
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getModelRolesListConverter());
        registry.addConverter(getModelRolesConverter());
        registry.addConverter(getModelRoleConverter());
        registry.addConverter(getUserRoleToStringConverter());
    }

    @Bean
    public ModelRolesListConverter getModelRolesListConverter() {
        return new ModelRolesListConverter(userRoleService);
    }

    @Bean
    public ModelRolesConverter getModelRolesConverter() {
        return new ModelRolesConverter(userRoleService);
    }

    @Bean
    public ModelRoleConverter getModelRoleConverter() {
        return new ModelRoleConverter(userRoleService);
    }

    @Bean
    public UserRoleToStringConverter getUserRoleToStringConverter() {
        return new UserRoleToStringConverter(userRoleService);
    }
}

