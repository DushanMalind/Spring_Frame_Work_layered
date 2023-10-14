package lk.ijse.spring.Service.impl;

import lk.ijse.spring.Service.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.util.List;

/**
 * `@authority` DUSHAN MALINDA
 * 20:21
 * 10/10/2023
 * ASUS
 * O14_Spring_Data_JPA
 * lk.ijse.spring.Service.impl
 */

@Service
@Transactional
public class QueryServiceImpl implements QueryService {




   /* @Override
    public void getAllOrders() {
        //queryRepo.findAllOrdersWithDetails();
    }*/








/*
 private final EntityManager entityManager;

    @Autowired
    public QueryServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void getAllOrders() {
        String sql = "select Orders.id,Orders.date,Orders.customer_id,Orders.total from Orders";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.getResultList();

 nativeQuery.getResultList().forEach(System.out::println);
    }
*/

}
