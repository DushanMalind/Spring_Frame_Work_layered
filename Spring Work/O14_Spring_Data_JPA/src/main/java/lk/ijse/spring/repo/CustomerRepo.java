package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * `@authority` DUSHAN MALINDA
 * 16:34
 * 02/10/2023
 * ASUS
 * O1_Spring_Core
 * lk.ijse.spring.dao
 */
public interface CustomerRepo extends JpaRepository<Customer,String> {

    List<Customer> findCustomerByAddress(String address);

    List<Customer> findByNameOrAddress(String name,String address);


    //Native Query
    @Query(value = "SELECT * from Customer",nativeQuery = true)
    List<Customer> getAllCustomers();

    //JPQL
    @Query(value = "SELECT c FROM Customer c")
    List<Customer> getAllCustomersTwo();

    //Hql
    @Query(value = "from Customer c where c.address=?1")
    List<Customer> getAllCustomersThree(String address);

    //what about params
    @Query(value = "SELECT * from Customer where name=:nm",nativeQuery = true)
    Customer searchCustomerWithName(@Param("nm")String name);

    //positional params
    @Query(value = "SELECT * from Customer where name=?1 and  address=?2",nativeQuery = true)
    Customer searchCustomerWithNameAndAddress(String name,String address);

}
