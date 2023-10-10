package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Item;
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
 * 10:27
 * 10/10/2023
 * ASUS
 * O14_Spring_Data_JPA
 * lk.ijse.spring.repo
 */
@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class ItemRepoTest {

    @Autowired
    ItemRepo repo;

    @Test
   public void getAllItem(){
        List<Item>all=repo.findAll();
        for (Item item : all) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testSaveItem(){
        Item item = new Item("I006","Dell",10,new BigDecimal(100000));
        repo.save(item);
    }


}