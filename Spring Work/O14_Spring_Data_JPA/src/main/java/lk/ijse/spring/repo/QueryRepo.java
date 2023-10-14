/*
package lk.ijse.spring.repo;

import lk.ijse.spring.dto.OrderDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.Order;
import java.util.List;

*/
/**
 * `@authority` DUSHAN MALINDA
 * 19:58
 * 10/10/2023
 * ASUS
 * O14_Spring_Data_JPA
 * lk.ijse.spring.Service
 *//*

public interface QueryRepo extends JpaRepository<OrderDetailsDTO,String> {

    */
/*@Query(value = "select Orders.id,Orders.date,Orders.customer_id,Orders.total from Orders",nativeQuery = true)
    void getAllOrders();*//*

    @Query("SELECT o FROM Orders o JOIN FETCH o.cusID c JOIN FETCH o.orderDetails od JOIN FETCH od.itemCode i")
    List<Order> findAllOrdersWithDetails();

}
*/
