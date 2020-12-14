package cr.ac.ucenfotec.cruds.repository;

import cr.ac.ucenfotec.cruds.domain.Leadership;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Leadership entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LeadershipRepository extends JpaRepository<Leadership, Long> {
}
