package gar.iso.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Objects;


/**
 * Created by Gor on 11/28/2017.
 */
@Entity
@Table(name = "user_detail")
public class User extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String role = "USER";

    private String password;

    @Transient
    private String confirmPassword;

    private boolean enabled = true;

//    @OneToOne(mappedBy = "cartUser", cascade = CascadeType.ALL)
//    private Cart cart;

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
        this.email = email.toLowerCase();
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

//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }

    private String validateName() {
        return "Va";
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hash(firstName, lastName, email, phoneNumber, role, password, confirmPassword, enabled);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.firstName, other.firstName)
                && Objects.equals(this.lastName, other.lastName)
                && Objects.equals(this.email, other.email)
                && Objects.equals(this.phoneNumber, other.phoneNumber)
                && Objects.equals(this.role, other.role)
                && Objects.equals(this.password, other.password)
                && Objects.equals(this.confirmPassword, other.confirmPassword)
                && Objects.equals(this.enabled, other.enabled);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("phoneNumber", phoneNumber)
                .append("role", role)
                .append("password", password)
                .append("confirmPassword", confirmPassword)
                .append("enabled", enabled)
                .toString();
    }
}
