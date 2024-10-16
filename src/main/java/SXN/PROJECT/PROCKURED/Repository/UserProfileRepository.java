package SXN.PROJECT.PROCKURED.Repository;

import SXN.PROJECT.PROCKURED.Model.User;
import SXN.PROJECT.PROCKURED.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    // Find the profile by user entity
    Optional<UserProfile> findByUser(User user);
}
