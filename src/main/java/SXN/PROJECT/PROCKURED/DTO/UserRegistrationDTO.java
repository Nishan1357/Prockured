package SXN.PROJECT.PROCKURED.DTO;

import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDTO {

    private String phoneNumber;
    private String password;
    private String confirmPassword;

    // Getters and setters

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}

