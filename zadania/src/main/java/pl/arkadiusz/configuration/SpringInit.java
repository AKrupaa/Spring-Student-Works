package pl.arkadiusz.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

@Configuration
public class SpringInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // dopisuj tutaj zawsze klasy konfiguracyjne
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringProjectConfiguration.class, HibernatePersistenceConfiguration.class, SecurityConfiguration.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{
                characterEncodingFilter
        };
    }
}