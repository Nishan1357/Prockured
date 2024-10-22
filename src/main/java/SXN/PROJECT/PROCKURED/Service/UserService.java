package SXN.PROJECT.PROCKURED.Service;

import SXN.PROJECT.PROCKURED.DTO.UserRegistrationDTO;
import SXN.PROJECT.PROCKURED.Model.User;
import SXN.PROJECT.PROCKURED.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserRegistrationDTO userRegistrationDTO ) {
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            return "Passwords do not match!";
        }
        Optional<User> existingUser = userRepository.findByPhoneNumber(userRegistrationDTO.getPhoneNumber());
        if (existingUser.isPresent()) {
            return "Phone number is already registered!";
        }

        User newUser = new User();
        newUser.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
        newUser.setPassword(userRegistrationDTO.getPassword());
        newUser.setCreatedAt(LocalDate.now().atStartOfDay());

        userRepository.save(newUser);
        return "User registered successfully!";
    }

    public Optional<User> login(String phoneNumber, String password) {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }


}
