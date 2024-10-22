package SXN.PROJECT.PROCKURED.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "client_profiles")
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Foreign key referencing users table

    private String pincode;
    private String shippingAddress;
    private String billingAddress;
    private String city;
    private String state;
    private String country;
    private String gstNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructors, Getters, and Setters...
    public ClientProfile() {}

    public ClientProfile(Long userId, String pincode, String shippingAddress, String billingAddress, String city, String state, String country, String gstNumber, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.pincode = pincode;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.gstNumber = gstNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
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

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
