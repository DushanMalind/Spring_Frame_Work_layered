package lk.ijse.spring.Service;


import lk.ijse.spring.dto.ItemDTO;

import java.util.List;

/**
 * `@authority` DUSHAN MALINDA
 * 10:02
 * 09/10/2023
 * ASUS
 * O1_Spring_Core
 * lk.ijse.spring.bo
 */
public interface ItemService {
    void saveItem(ItemDTO dto);

    void deleteItem(String id);


    List<ItemDTO> getAllItem();


    ItemDTO findItem(String id);

    void updateItem(ItemDTO c);
}
