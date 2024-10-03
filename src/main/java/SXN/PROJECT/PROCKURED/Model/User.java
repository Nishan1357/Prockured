package SXN.PROJECT.PROCKURED.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users") // This tells Hibernate to create a table named 'users'
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the primary key
    private Long id;

//    @Column(name = "PhoneNumber") // Customize column name, uniqueness, and nullability
    private String phoneNumber;

//    @Column(name = "Password") // Make sure password cannot be null
    private String password;

//    @Column(name = "Registered_at") // Custom column name for date
    private LocalDate registeredAt;

    // Getters and setters...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
    }
}
