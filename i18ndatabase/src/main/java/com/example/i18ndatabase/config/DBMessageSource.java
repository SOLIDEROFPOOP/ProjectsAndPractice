package com.example.i18ndatabase.config;

import com.example.i18ndatabase.entities.Language;
import com.example.i18ndatabase.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;
@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {
    @Autowired
    private LanguageRepository languageRepository;
    private static final String DEFAULT_LOCALE_CODE = "en";
    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {
        Language message = languageRepository.findByKeyAndLocale(key,locale.getLanguage());
        if (message == null){
            message = languageRepository.findByKeyAndLocale(key, DEFAULT_LOCALE_CODE);
        }
        return new MessageFormat(message.getContent(), locale);
    }
}
