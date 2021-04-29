package pl.arkadiusz.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import pl.arkadiusz.service.CarTypeService;
import pl.arkadiusz.utils.ModelCarTypeConverter;
import pl.arkadiusz.utils.ModelCarTypeListConverter;

import javax.annotation.Resource;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("pl.arkadiusz")
public class SpringConfiguration implements WebMvcConfigurer {

//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("tilesConfiguration/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        registry.viewResolver(tilesViewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    //    Configure message (language i18n) source directory
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/resources/i18n/language");
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

    @Resource(name = "carTypeService")
    private CarTypeService carTypeService;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getModelCarTypeListConverter());
        registry.addConverter(getModelCarTypeConverter());
    }

    @Bean
    public ModelCarTypeListConverter getModelCarTypeListConverter() {
        return new ModelCarTypeListConverter(carTypeService);
    }

    @Bean
    public ModelCarTypeConverter getModelCarTypeConverter() {
        return new ModelCarTypeConverter(carTypeService);
    }
}
