package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
