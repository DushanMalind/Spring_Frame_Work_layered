package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` DUSHAN MALINDA
 * 09:18
 * 10/10/2023
 * ASUS
 * O14_Spring_Data_JPA
 * lk.ijse.spring.controller
 */

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {

    @PostMapping
    public ResponseUtil PurchaseOrder(@RequestBody OrdersDTO od){

        return new ResponseUtil("Ok","Successfully Purchase",od);
    }
}
