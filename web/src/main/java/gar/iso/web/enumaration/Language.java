package gar.iso.web.enumaration;

import java.util.Locale;

/**
 * Created by Gor on 12/10/2017.
 */
public enum Language {
    ENGLISH(1, new Locale("en"), "English"),
    RUSSIAN(2, new Locale("ru"), "Russian");

    private int langId;

    private static Language language;

    private final int key;

    private final Locale locale;

    private final String langName;

    private Language(int key, Locale locale, String langName) {
        this.key = key;
        this.locale = locale;
        this.langName = langName;
    }

    public int getKey() {
        return this.key;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getLangName() {
        return this.langName;
    }

    public static void setLanguage(String langLocale) throws IllegalArgumentException {
        if (langLocale.equalsIgnoreCase("English")
                || langLocale.equalsIgnoreCase("Russian")) {
            language = Language.valueOf(langLocale.toUpperCase());
        } else {
            language = Language.valueOf("RUSSIAN");
        }
    }

    public static Language getLanguage() {
        return language;
    }
}
