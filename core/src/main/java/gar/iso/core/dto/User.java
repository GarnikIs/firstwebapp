package gar.iso.core.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gor on 11/28/2017.
 */
@Entity
@Table(name = "user_detail")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    @NotBlank(message = "Please enter your first name")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Please enter your last name")
    private String lastName;

    @NotBlank(message = "Please enter your email")
    private String email;

    @Column(name = "phone_number")
    @NotBlank(message = "Please enter your phone number")
    private String phoneNumber;

    private String role;

    @NotBlank(message = "Please enter your password")
    private String password;

    @Transient
    @NotBlank(message = "Confirmation password must be same")
    private String confirmPassword;

    private boolean enabled = true;

    @OneToOne(mappedBy = "cartUser", cascade = CascadeType.ALL)
    private Cart cart;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", cart=" + cart +
                '}';
    }

}
