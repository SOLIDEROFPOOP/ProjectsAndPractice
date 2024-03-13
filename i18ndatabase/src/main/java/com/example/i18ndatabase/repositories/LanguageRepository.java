package com.example.i18ndatabase.repositories;

import com.example.i18ndatabase.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Language findByKeyAndLocale(String key, String locale);
}
