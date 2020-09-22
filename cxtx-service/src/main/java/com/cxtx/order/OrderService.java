package com.cxtx.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public int createOrder(Order order){
        return orderMapper.createOrder(order);
    }

    public List<Order> selectOrderByUsername(String account_username){
        return orderMapper.selectOrderByUsername(account_username);
    }

}
