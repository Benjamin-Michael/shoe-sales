package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {
}
