package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * `@authority` DUSHAN MALINDA
 * 10:01
 * 10/10/2023
 * ASUS
 * O14_Spring_Data_JPA
 * lk.ijse.spring.repo
 */

@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

    @Test
    public void testGetAllCustomer(){
        List<Customer> all = repo.findAll();
        for (Customer customer : all) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void testSaveCustomer(){
        Customer customer = new Customer("C006","Dushan","Galle",new BigDecimal(100000));
        repo.save(customer);
    }

    @Test
    public void queryMethodOne(){
        List<Customer> galle = repo.findCustomerByAddress("Galle");
        for (Customer customer : galle) {
            System.out.println(customer.toString());
        }

    }

    @Test
    public void queryMethodTwo(){
        List<Customer> galle = repo.findByNameOrAddress("Dushan", "Galle");
        for (Customer customer : galle) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void queryMethodThree(){
        List<Customer> allCustomers = repo.getAllCustomers();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }
    }

    @Test
    public void queryMethodFour(){
        List<Customer> allCustomers = repo.getAllCustomersTwo();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }
    }

    @Test
    public void queryMethodFive(){
        List<Customer> allCustomers = repo.getAllCustomersThree("Galle");
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }
    }

    @Test
    public void queryMethodSix(){
        Customer customer = repo.searchCustomerWithName("sunil");
        System.out.println(customer.toString());
    }

    @Test
    public void queryMethodSeven(){
        Customer customer = repo.searchCustomerWithNameAndAddress("sunil", "Mathara");
        System.out.println(customer.toString());
    }
}