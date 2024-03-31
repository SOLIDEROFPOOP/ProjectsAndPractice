package com.example.i18n.config;

import com.example.i18n.entities.Language;
import com.example.i18n.repositories.LanguageRepository;
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
    protected MessageFormat resolveCode(String code, Locale locale) {
        Language message = languageRepository.findByKeyAndLocale(code,locale.getLanguage());
        if (message == null){
            message = languageRepository.findByKeyAndLocale(code, DEFAULT_LOCALE_CODE);
        }
        return new MessageFormat(message.getContent(), locale);
    }
}
