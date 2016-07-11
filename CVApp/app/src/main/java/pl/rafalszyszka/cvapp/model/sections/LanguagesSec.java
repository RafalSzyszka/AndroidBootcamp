package pl.rafalszyszka.cvapp.model.sections;

import java.util.ArrayList;

import pl.rafalszyszka.cvapp.model.Language;

/**
 * Created by Squier on 2016-07-02.
 */
public class LanguagesSec {

    private ArrayList<Language> languages;

    public LanguagesSec(ArrayList<Language> languages) {
        this.languages = languages;
    }

    /**
     * Add language to languages section
     *
     * @param language language with level
     */
    public void addLanguage(Language language) {
        languages.add(language);
    }

    /**
     * Return a language by given index
     *
     * @param index index f language
     * @return language with level
     */
    public Language getLanguageByIndex(int index) {
        return languages.get(index);
    }
}
