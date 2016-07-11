package pl.rafalszyszka.cvapp.model;

/**
 * Created by Squier on 2016-07-02.
 */
public class Language {

    private String language;
    private LanguageLevel level;

    /**
     * Language description
     *
     * @param language what language it is
     * @param level    language level
     */
    public Language(String language, LanguageLevel level) {
        this.language = language;
        this.level = level;
    }

    /**
     * Set language level
     *
     * @param language      what language it is
     * @param languageLevel language level
     */
    public void setLanguageLevel(String language, LanguageLevel languageLevel) {
        this.language = language;
        this.level = languageLevel;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }
}
