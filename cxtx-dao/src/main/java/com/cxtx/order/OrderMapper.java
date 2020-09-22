package com.cxtx.order;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    int createOrder(Order order);
    List<Order> selectOrderByUsername(String account_username);

}
