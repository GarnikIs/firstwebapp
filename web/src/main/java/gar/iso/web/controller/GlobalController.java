package gar.iso.web.controller;

import gar.iso.core.dao.UserDao;
import gar.iso.core.dto.User;
import gar.iso.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by Gor on 12/1/2017.
 */
@ControllerAdvice
public class GlobalController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserDao userDao;

    private UserModel userModel = null;

    @ModelAttribute("userModel")
    public UserModel getUserModel() {
        if (session.getAttribute("userModel") == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userDao.getUserByEmail(auth.getName());
            if (user != null) {
                userModel = new UserModel();
                userModel.setId(user.getUserId());
                userModel.setFullName(user.getFirstName() + " " + user.getLastName());
                userModel.setEmail(user.getEmail());
                userModel.setRole(user.getRole());
                if (user.getRole().equals("USER")) {
                    userModel.setCart(user.getCart());
                }
                session.setAttribute("userModel", userModel);
                return userModel;
            }
        }
        return (UserModel) session.getAttribute("userModel");
    }
}
