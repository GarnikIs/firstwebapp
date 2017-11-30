package gar.iso.web.model;

import gar.iso.core.dto.User;
import gar.iso.core.dto.UserAddress;

import java.io.Serializable;

/**
 * Created by Gor on 11/30/2017.
 */
public class RegisterModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;

    private UserAddress billing;

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

    @Override
    public String toString() {
        return "RegisterModel{" +
                "user=" + user +
                ", billing=" + billing +
                '}';
    }
}
