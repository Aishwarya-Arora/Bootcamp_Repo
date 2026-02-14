package com.assignment.rest.RestfulAssignment2.config;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.LocaleResolver;
import java.util.Locale;


@Configuration
public class LocaleConfig {

    @Bean
    public LocaleResolver localeResolver() {
        //LocaleResolver decides which language to use defined in the header
        AcceptHeaderLocaleResolver slr = new AcceptHeaderLocaleResolver();
        //AcceptHeaderLocalResolver is used to read the accept-language property from the header
        slr.setDefaultLocale(Locale.ENGLISH);
        //setting the default as english
        return slr;
    }
}