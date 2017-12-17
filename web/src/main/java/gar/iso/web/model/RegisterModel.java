package gar.iso.web.model;

import gar.iso.core.dto.User;
import gar.iso.core.dto.UserAddress;
import gar.iso.web.enumaration.Language;

import java.io.Serializable;

/**
 * Created by Gor on 11/30/2017.
 */
public class RegisterModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;

    private UserAddress billing;

    private String title;

    private Language language;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAddress getBilling() {
        return billing;
    }

    public void setBilling(UserAddress billing) {
        this.billing = billing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "user=" + user +
                ", billing=" + billing +
                ", title=" + title +
                ", language=" + language +
                '}';
    }
}
