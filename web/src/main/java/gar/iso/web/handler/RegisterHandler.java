package gar.iso.web.handler;

import gar.iso.core.dao.UserDao;
import gar.iso.core.dto.Cart;
import gar.iso.core.dto.User;
import gar.iso.core.dto.UserAddress;
import gar.iso.web.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;


/**
 * Created by Gor on 11/30/2017.
 */
@Component
public class RegisterHandler {

    @Autowired
    private UserDao userDao;

    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }

    public void addBilling(RegisterModel registerModel, UserAddress billing) {
        registerModel.setBilling(billing);
    }

    public String registerUser(RegisterModel registerModel) {
        String transitionValue = "success";
//        fetch the user
        User user = registerModel.getUser();
        if (user.getRole().equals("USER")) {
            Cart cart = new Cart();
            cart.setCartUser(user);
            user.setCart(cart);
        }
//        save the current user
        userDao.addNewUser(user);

//        get the address
        UserAddress billingAddress = registerModel.getBilling();
        billingAddress.setUser(user);
        billingAddress.setBilling(true);
//        save the user address
        userDao.addUserAddress(billingAddress);

        return transitionValue;
    }

    public String validateUser(User user, MessageContext errorMessage) {
        String transitionValue = "success";
//        validates passwords equality
        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("confirmPassword")
                    .defaultText("Passwords do not match")
                    .build());
            transitionValue = "failure";
        }

//        validates email not to be duplicate
        if (userDao.getUserByEmail(user.getEmail()) != null) {
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("email")
                    .defaultText("The mentioned email is already in use")
                    .build());
            transitionValue = "failure";
        }

        return transitionValue;
    }
}
