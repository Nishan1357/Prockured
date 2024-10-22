package SXN.PROJECT.PROCKURED.Repository;
import SXN.PROJECT.PROCKURED.Model.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {
    Optional<ClientProfile> findByUserId(Long userId);
}
