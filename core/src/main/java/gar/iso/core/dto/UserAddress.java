package gar.iso.core.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gor on 11/28/2017.
 */
@Entity
@Table(name = "user_address")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @ManyToOne
    @JoinColumn(name = "address_user_id", foreignKey = @ForeignKey(name = "fk_addressUserId"))
    private User user;

    @Column(name = "address_line")
    @NotBlank(message = "Please enter your address")
    private String addressLine;

    @NotBlank(message = "Please enter your city")
    private String city;

    @NotBlank(message = "Please enter your state")
    private String state;

    @Column(name = "zip_code")
    @NotBlank(message = "Please enter your zip code")
    private String zipCode;

    @NotBlank(message = "Please enter your country")
    private String country;

    private boolean shipping;

    private boolean billing;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", user='" + user + '\'' +
                ", addressLineOne='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", shipping=" + shipping +
                ", billing=" + billing +
                '}';
    }

}
