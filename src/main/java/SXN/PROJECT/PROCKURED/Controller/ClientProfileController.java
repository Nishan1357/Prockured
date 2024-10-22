package SXN.PROJECT.PROCKURED.Controller;

import SXN.PROJECT.PROCKURED.Model.ClientProfile;
import SXN.PROJECT.PROCKURED.Repository.ClientProfileRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/client-profile")
public class ClientProfileController {

    @Autowired
    private ClientProfileRepository clientProfileRepository;

    // Create client profile
    @PostMapping("/create")
    public ResponseEntity<String> createClientProfile(@RequestBody ClientProfile clientProfile, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(401).body("User is not logged in.");
        }

        // Check if client profile already exists
        Optional<ClientProfile> existingProfile = clientProfileRepository.findByUserId(userId);
        if (existingProfile.isPresent()) {
            return ResponseEntity.badRequest().body("Client profile already exists.");
        }

        // Create and save new client profile
        clientProfile.setUserId(userId);
        clientProfile.setCreatedAt(LocalDateTime.now());
        clientProfile.setUpdatedAt(LocalDateTime.now());
        clientProfileRepository.save(clientProfile);

        return ResponseEntity.ok("Client profile created successfully.");
    }

    // Get client profile
    @GetMapping("/get")
    public ResponseEntity<?> getClientProfile(HttpSession session) {
        // Check if user is logged in
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(401).body("User is not logged in.");
        }

        // Retrieve the client profile
        Optional<ClientProfile> clientProfile = clientProfileRepository.findByUserId(userId);
        if (clientProfile.isPresent()) {
            return ResponseEntity.ok(clientProfile.get());
        } else {
            return ResponseEntity.status(404).body("Client profile not found.");
        }
    }
}
