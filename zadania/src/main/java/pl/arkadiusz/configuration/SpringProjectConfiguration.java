package pl.arkadiusz.configuration;

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
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import pl.arkadiusz.service.AddressService;
import pl.arkadiusz.service.AppUserRoleService;
import pl.arkadiusz.utils.AppUserRoleConverter;
import pl.arkadiusz.utils.AppUserRoleListConverter;
import pl.arkadiusz.utils.UserAddressConverter;

import javax.annotation.Resource;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("pl.arkadiusz")
public class SpringProjectConfiguration implements WebMvcConfigurer {

    @Resource(name = "addressService")
    private AddressService addressService;
    @Resource(name = "appUserRoleService")
    private AppUserRoleService appUserRoleService;

    /*
    Configure TilesConfigurer
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("tilesConfiguration/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    /*
    Configure ViewResolvers to deliver preferred values
     */
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        registry.viewResolver(tilesViewResolver);
    }

    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    // internationalize
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        // setBasename("/resources/i18n/poczatkowyFragmentPlikowProperties")
        reloadableResourceBundleMessageSource.setBasename("/resources/i18n/language");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF8");
        return reloadableResourceBundleMessageSource;
    }

    // internationalize
    // default language
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale(("en")));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    // internationalize
    // interceptor - dodatkowa metoda przechwytujaca żądania z przegladarki i moga wykonywac dodatkowe operacje
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        interceptorRegistry.addInterceptor(interceptor);
    }

    // validation
    @Bean
//    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        // add text source -> i18n
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    // converters
    @Bean
    public UserAddressConverter getMyUserAddressConverter() {
        return new UserAddressConverter(addressService);
    }

    @Bean
    public AppUserRoleConverter getMyAppUserRoleConverter() {
        return new AppUserRoleConverter(appUserRoleService);
    }

    @Bean
    public AppUserRoleListConverter getMyAppUserRoleListConverter() {
        return new AppUserRoleListConverter(appUserRoleService);
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(getMyUserAddressConverter());
        formatterRegistry.addConverter(getMyAppUserRoleConverter());
        formatterRegistry.addConverter(getMyAppUserRoleListConverter());
    }

}
