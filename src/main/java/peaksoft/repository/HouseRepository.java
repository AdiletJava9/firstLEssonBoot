package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.House;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
