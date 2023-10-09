package lk.ijse.spring.Service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * `@authority` DUSHAN MALINDA
 * 10:02
 * 09/10/2023
 * ASUS
 * O1_Spring_Core
 * lk.ijse.spring.bo
 */
public interface CustomerService {

     void addCustomer(CustomerDTO dto);


     void deleteCustomer(String id);


     List<CustomerDTO> getAllCustomer();


     CustomerDTO findCustomer(String id);

     void updateCustomer(CustomerDTO c);
}
