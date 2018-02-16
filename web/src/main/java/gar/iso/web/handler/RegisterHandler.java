package gar.iso.web.handler;

import gar.iso.core.dao.UserDao;
//import gar.iso.core.dto.Cart;
import org.springframework.context.MessageSource;
import gar.iso.core.dto.User;
import gar.iso.core.dto.UserAddress;
import gar.iso.web.enumaration.Language;
import gar.iso.web.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static gar.iso.web.controller.GlobalController.language;


/**
 * Created by Gor on 11/30/2017.
 */
@Component
public class RegisterHandler {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    public RegisterModel init() {
        RegisterModel registerModel = new RegisterModel();
        int langKey = language.getKey() == 2 ? 2 : 1;
        registerModel.setTitle(messageSource.getMessage("registration.title", null, language.setLocale(langKey)));
        registerModel.setLanguage(Language.getLanguage());
        return registerModel;
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
//        if (user.getRole().equals("USER")) {
//            Cart cart = new Cart();
//            cart.setCartUser(user);
//            user.setCart(cart);
//        }

//        encode user's password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

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

    public String validateUser(User user, UserAddress billingAddress, MessageContext errorMessage) {
        String transitionValue = "success";
        int langKey = language.getKey() == 2 ? 2 : 1;
//        validates first name not to be blank
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            String errMessEmptyUserName = langKey == 2 ? messageSource.getMessage("error.message.insert.first.name", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.insert.first.name", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("firstName")
                    .defaultText(errMessEmptyUserName)
                    .build());
            transitionValue = "failure";
        }
//        validates last name not to be blank
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            String errMessEmptyUserName = langKey == 2 ? messageSource.getMessage("error.message.insert.last.name", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.insert.last.name", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("lastName")
                    .defaultText(errMessEmptyUserName)
                    .build());
            transitionValue = "failure";
        }
//        validates email not to be blank
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            String errMessEmptyUserName = langKey == 2 ? messageSource.getMessage("error.message.blank.email", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.blank.email", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("email")
                    .defaultText(errMessEmptyUserName)
                    .build());
            transitionValue = "failure";
        }
//        validates phone number not to be blank
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            String errMessEmptyUserName = langKey == 2 ? messageSource.getMessage("error.message.insert.phone.number", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.insert.phone.number", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("phoneNumber")
                    .defaultText(errMessEmptyUserName)
                    .build());
            transitionValue = "failure";
        }
//        validates password not to be blank
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            String errMessEmptyUserName = langKey == 2 ? messageSource.getMessage("error.message.insert.password", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.insert.password", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("password")
                    .defaultText(errMessEmptyUserName)
                    .build());
            transitionValue = "failure";
        }
//        validates confirm password not to be blank
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            String errMessEmptyUserName = langKey == 2 ? messageSource.getMessage("error.message.insert.confirm.password", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.insert.confirm.password", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("confirmPassword")
                    .defaultText(errMessEmptyUserName)
                    .build());
            transitionValue = "failure";
        }
//        validates passwords equality
        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            String errMessPassMisMatch = langKey == 2 ? messageSource.getMessage("error.message.register.password.mismatch", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.register.password.mismatch", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("confirmPassword")
                    .defaultText(errMessPassMisMatch)
                    .build());
            transitionValue = "failure";
        }

//        validates email not to be duplicate
        if (userDao.getUserByEmail(user.getEmail()) != null) {
            String errMessDuplEmail = langKey == 2 ? messageSource.getMessage("error.message.register.duplicate.email", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.register.duplicate.email", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("email")
                    .defaultText(errMessDuplEmail)
                    .build());
            transitionValue = "failure";
        }
//        validates phone number not to be duplicate
        if (userDao.getUserByPhoneNumber(user.getPhoneNumber()) != null) {
            String errMessDuplPhone = langKey == 2 ? messageSource.getMessage("error.message.register.duplicate.phone.number", null, language.setLocale(langKey))
                    : messageSource.getMessage("error.message.register.duplicate.phone.number", null, language.setLocale(langKey));
            errorMessage.addMessage(new MessageBuilder().error()
                    .source("phoneNumber")
                    .defaultText(errMessDuplPhone)
                    .build());
            transitionValue = "failure";
        }

//        validates address line not to be duplicate phone number
        if (billingAddress.getAddressLine() != null) {
            if(billingAddress.getAddressLine().isEmpty()) {
                String errMessAddressLine = langKey == 2 ? messageSource.getMessage("error.message.insert.address.line", null, language.setLocale(langKey))
                        : messageSource.getMessage("error.message.insert.address.line", null, language.setLocale(langKey));
                errorMessage.addMessage(new MessageBuilder().error()
                        .source("addressLine")
                        .defaultText(errMessAddressLine)
                        .build());
                transitionValue = "failure";
            }
        }
//        validates city not to be duplicate phone number
        if (billingAddress.getCity() != null) {
            if (billingAddress.getCity().isEmpty()) {
                String errMessCity = langKey == 2 ? messageSource.getMessage("error.message.insert.city", null, language.setLocale(langKey))
                        : messageSource.getMessage("error.message.insert.city", null, language.setLocale(langKey));
                errorMessage.addMessage(new MessageBuilder().error()
                        .source("city")
                        .defaultText(errMessCity)
                        .build());
                transitionValue = "failure";
            }
        }
//        validates zip code not to be duplicate phone number
        if ( billingAddress.getZipCode() != null) {
            if (billingAddress.getZipCode().isEmpty()) {
                String errMessZipcode = langKey == 2 ? messageSource.getMessage("error.message.insert.zip.code", null, language.setLocale(langKey))
                        : messageSource.getMessage("error.message.insert.zip.code", null, language.setLocale(langKey));
                errorMessage.addMessage(new MessageBuilder().error()
                        .source("zipCode")
                        .defaultText(errMessZipcode)
                        .build());
                transitionValue = "failure";
            }
        }
//        validates state not to be duplicate phone number
        if (billingAddress.getState() != null) {
            if(billingAddress.getState().isEmpty()) {
                String errMessState = langKey == 2 ? messageSource.getMessage("error.message.insert.state", null, language.setLocale(langKey))
                        : messageSource.getMessage("error.message.insert.state", null, language.setLocale(langKey));
                errorMessage.addMessage(new MessageBuilder().error()
                        .source("state")
                        .defaultText(errMessState)
                        .build());
                transitionValue = "failure";
            }
        }
//        validates country line not to be duplicate phone number
        if (billingAddress.getCountry() != null) {
            if(billingAddress.getCountry().isEmpty()) {
                String errMessCountry = langKey == 2 ? messageSource.getMessage("error.message.insert.country", null, language.setLocale(langKey))
                        : messageSource.getMessage("error.message.insert.country", null, language.setLocale(langKey));
                errorMessage.addMessage(new MessageBuilder().error()
                        .source("country")
                        .defaultText(errMessCountry)
                        .build());
                transitionValue = "failure";
            }
        }



        return transitionValue;
    }
}
