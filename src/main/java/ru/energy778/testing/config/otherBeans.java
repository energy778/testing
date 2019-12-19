package ru.energy778.testing.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class otherBeans {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigInDev(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/locBundle");
//        ms.setDefaultEncoding("UTF-8");
        ms.setDefaultEncoding("windows-1251");
        return ms;
    }

}
