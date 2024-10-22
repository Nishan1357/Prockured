package SXN.PROJECT.PROCKURED.Repository;

import SXN.PROJECT.PROCKURED.Model.SupplierProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SupplierProfileRepository extends JpaRepository<SupplierProfile, Long> {
    Optional<SupplierProfile> findByUserId(Long userId);
}
