package lk.ijse.spring.Service.impl;

import lk.ijse.spring.Service.ItemService;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * `@authority` DUSHAN MALINDA
 * 10:05
 * 09/10/2023
 * ASUS
 * O1_Spring_Core
 * lk.ijse.spring.servise.impl
 */


@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveItem(ItemDTO dto) {
        itemRepo.save(mapper.map(dto, Item.class));
    }

    @Override
    public void deleteItem(String id) {
        itemRepo.deleteById(id);
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item>all=itemRepo.findAll();
        return mapper.map(all, new TypeToken<List<ItemDTO>>(){}.getType());
    }

    @Override
    public ItemDTO findItem(String id) {
        Item item = itemRepo.findById(id).get();
        return mapper.map(item,ItemDTO.class);
    }

    @Override
    public void updateItem(ItemDTO c) {
        Item map = mapper.map(c, Item.class);
        itemRepo.save(map);
    }
}
