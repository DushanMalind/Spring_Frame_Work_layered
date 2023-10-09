package lk.ijse.spring.controller;

import lk.ijse.spring.Service.ItemService;
import lk.ijse.spring.Service.impl.ItemServiceImpl;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * `@authority` DUSHAN MALINDA
 * 11:17
 * 09/10/2023
 * ASUS
 * O1_Spring_Core
 * lk.ijse.spring.controller
 */

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto){
        itemService.saveItem(dto);
        return new ResponseUtil("Ok","Successfully Added",dto);
    }


    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteItem(@RequestParam String id){
        itemService.deleteItem(id);
        return new ResponseUtil("Ok","Successfully Deleted",id);
    }

    @GetMapping
    public ResponseUtil getAllItem(){
        return new ResponseUtil("Ok","Successfully Loaded",itemService.getAllItem());
    }

    @GetMapping(params = {"id"})
    public ResponseUtil findItem(String id){
        return new ResponseUtil("Ok","Successfully", itemService.findItem(id));
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody ItemDTO c){
        itemService.updateItem(c);
        return new ResponseUtil("Ok","Successfully Updated",c);
    }

}
