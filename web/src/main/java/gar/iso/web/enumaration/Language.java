package gar.iso.web.enumaration;

import java.util.Locale;

/**
 * Created by Gor on 12/10/2017.
 */
public enum Language {
    ENGLISH(1, new Locale("en"), "English"),
    RUSSIAN(2, new Locale("ru"), "Russian"),
    ARMENIAN(3, new Locale("arm"), "Armenian");

    private int langId;

    private static Language language;

    private final int key;

    private final Locale locale;

    private final String langName;

    Language(int key, Locale locale, String langName) {
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

    public Locale setLocale(int langKey) {
        Locale locale = (langKey == 2) ? new Locale("ru")
                : ( (langKey == 1) ? new Locale("en")
                        : new Locale("arm") );
        return locale;
    }

    public String getLangName() {
        return this.langName;
    }

    public static void setLanguage(String langLocale) throws IllegalArgumentException {
        if (langLocale.equalsIgnoreCase("English")
                || langLocale.equalsIgnoreCase("Russian") || langLocale.equalsIgnoreCase("Armenian")) {
            language = Language.valueOf(langLocale.toUpperCase());
        } else {
            language = Language.valueOf("ARMENIAN");
        }
    }

    public static Language getLanguage() {
        return language;
    }
}
