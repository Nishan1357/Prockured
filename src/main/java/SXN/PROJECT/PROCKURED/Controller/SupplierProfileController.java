package SXN.PROJECT.PROCKURED.Controller;

import SXN.PROJECT.PROCKURED.Model.SupplierProfile;
import SXN.PROJECT.PROCKURED.Repository.SupplierProfileRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/supplier-profile")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileRepository supplierProfileRepository;

    // Create supplier profile
    @PostMapping("/create")
    public ResponseEntity<String> createSupplierProfile(@RequestBody SupplierProfile supplierProfile, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(401).body("User is not logged in.");
        }

        // Check if supplier profile already exists
        Optional<SupplierProfile> existingProfile = supplierProfileRepository.findByUserId(userId);
        if (existingProfile.isPresent()) {
            return ResponseEntity.badRequest().body("Supplier profile already exists.");
        }

        // Create and save new supplier profile
        supplierProfile.setUserId(userId);
        supplierProfile.setCreatedAt(LocalDateTime.now());
        supplierProfile.setUpdatedAt(LocalDateTime.now());
        supplierProfileRepository.save(supplierProfile);

        return ResponseEntity.ok("Supplier profile created successfully.");
    }

    // Get supplier profile

    @GetMapping("/get")
    public ResponseEntity<Object> getSupplierProfile(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        // Check if the user is logged in
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in.");
        }

        // Find the supplier profile by userId
        Optional<SupplierProfile> supplierProfile = supplierProfileRepository.findByUserId(userId);

        // Return the supplier profile if found, otherwise return 404
        if (supplierProfile.isPresent()) {
            return ResponseEntity.ok(supplierProfile.get()); // Return the SupplierProfile
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier profile not found.");
        }
    }



}
