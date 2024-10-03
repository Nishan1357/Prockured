package SXN.PROJECT.PROCKURED.Controller;
import SXN.PROJECT.PROCKURED.DTO.UserRegistrationDTO;
import SXN.PROJECT.PROCKURED.Model.User;
import SXN.PROJECT.PROCKURED.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    // User registration
    //http://localhost:8080/users/register
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match.");
        }

        // Check if user already exists
        Optional<User> existingUser = userRepository.findByPhoneNumber(registrationDTO.getPhoneNumber());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Phone number already registered.");
        }

        // Create and save new user
        User user = new User();
        user.setPhoneNumber(registrationDTO.getPhoneNumber());
        user.setPassword(registrationDTO.getPassword()); // Add encryption in a real scenario
        user.setRegisteredAt(LocalDate.now());

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }


    // User login with session management (GET)
    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String phoneNumber, @RequestParam String password, HttpServletRequest request) {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);

        if (user.isEmpty() || !user.get().getPassword().equals(password)) {
            return ResponseEntity.status(401).body("Invalid phone number or password.");
        }

        // Create session and store user ID
        HttpSession session = request.getSession(true); // true means to create a new session if one doesn't exist
        session.setAttribute("userId", user.get().getId());

        return ResponseEntity.ok("Login successful. Session created.");
    }

    // User logout
    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // false means do not create a new session
        if (session != null) {
            session.invalidate(); // Invalidate the session
            return ResponseEntity.ok("User logged out successfully.");
        }
        return ResponseEntity.badRequest().body("No active session to log out.");
    }

    // Check if user is logged in
    @GetMapping("/check-session")
    public ResponseEntity<String> checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Get existing session, do not create new
        if (session != null && session.getAttribute("userId") != null) {
            return ResponseEntity.ok("User is logged in.");
        }
        return ResponseEntity.status(401).body("No active session, user is logged out.");
    }
}