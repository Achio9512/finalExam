package cr.ac.ucenfotec.cruds.repository;

import cr.ac.ucenfotec.cruds.domain.Deparment;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Deparment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DeparmentRepository extends JpaRepository<Deparment, Long> {
}
