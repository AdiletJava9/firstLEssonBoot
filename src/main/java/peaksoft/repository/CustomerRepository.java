package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
}
