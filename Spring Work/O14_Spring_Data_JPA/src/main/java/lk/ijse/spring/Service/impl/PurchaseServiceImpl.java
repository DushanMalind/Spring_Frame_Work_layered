package lk.ijse.spring.Service.impl;

import lk.ijse.spring.Service.PurchaseService;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.OrdersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * `@authority` DUSHAN MALINDA
 * 09:36
 * 10/10/2023
 * ASUS
 * O14_Spring_Data_JPA
 * lk.ijse.spring.Service.impl
 */

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    OrdersRepo ordersRepo;

    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void PurchaseOrder(OrdersDTO dto) {
        if (ordersRepo.existsById(dto.getOid())){
            throw new RuntimeException(dto.getOid()+"Order Already Exist");
        }

        Orders map = mapper.map(dto, Orders.class);
        ordersRepo.save(map);


        for (OrderDetails orderDetails : map.getOrderDetails()) {
            Item item = itemRepo.findById(orderDetails.getItemCode()).get();
            item.setQtyOnHand(item.getQtyOnHand()-orderDetails.getQty());
            itemRepo.save(item);

        }


    }
}
