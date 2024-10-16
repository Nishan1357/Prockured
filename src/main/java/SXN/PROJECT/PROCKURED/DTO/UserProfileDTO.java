package SXN.PROJECT.PROCKURED.DTO;

public class UserProfileDTO {

    private String name;
    private String email;
    private String city;
    private int pincode;
    private String state;
    private String country;



    // Getters and setters...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
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

    // Constructor


    public UserProfileDTO(String name, String email, String city, int pincode, String state, String country) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
    }

    public UserProfileDTO() {
        // Default constructor
    }
}

