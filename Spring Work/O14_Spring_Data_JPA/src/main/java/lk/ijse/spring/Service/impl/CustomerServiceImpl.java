package lk.ijse.spring.Service.impl;

import lk.ijse.spring.Service.CustomerService;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.List;

/**
 * `@authority` DUSHAN MALINDA
 * 10:02
 * 09/10/2023
 * ASUS
 * O1_Spring_Core
 * lk.ijse.spring.bo
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        //Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());

        if (customerRepo.existsById(dto.getId())) {
            throw new RuntimeException(dto.getId()+" is already available, please insert a new ID");
        }

        /*Customer map = mapper.map(dto, Customer.class);
        // first param=source
        // type you want to convert
        customerRepo.save(map);*/

        customerRepo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException(id+ " Customer is not available, please check the ID before delete.!");
        }

        customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer>all=customerRepo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO findCustomer(String id) {
        Customer customer = customerRepo.findById(id).get();
        return mapper.map(customer,CustomerDTO.class);
    }

    @Override
    public void updateCustomer(CustomerDTO c) {
        Customer map = mapper.map(c, Customer.class);
        customerRepo.save(map);
    }
}
