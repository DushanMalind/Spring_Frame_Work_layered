package lk.ijse.spring.repo;

import lk.ijse.spring.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * `@authority` DUSHAN MALINDA
 * 09:16
 * 10/10/2023
 * ASUS
 * O14_Spring_Data_JPA
 * lk.ijse.spring.Service
 */
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,String> {
}
