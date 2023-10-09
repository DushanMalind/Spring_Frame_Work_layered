package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * `@authority` DUSHAN MALINDA
 * 16:34
 * 02/10/2023
 * ASUS
 * O1_Spring_Core
 * lk.ijse.spring.dao
 */
public interface CustomerRepo extends JpaRepository<Customer,String> {
}
