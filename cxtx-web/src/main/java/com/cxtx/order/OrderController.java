package com.cxtx.order;


import com.cxtx.util.ContextUtil;
import com.fasterxml.jackson.datatype.jsr310.deser.JSR310DateTimeDeserializerBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Api(tags = "订单相关")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createorder")
    @ApiOperation(value ="创建订单")
    public String addOrder(
            String orderEncoding,
            int orderSiteId,
            String routeName,
            String accoutUserName,
            float orderTotalPrice,
            float orderReducePrice,
            float orderActualPrice,
    //        Date orderCreatTime,
    //        Date orderPayTime,
            String orderNote
    ) {

//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String orderCreatTime=sdf.format(date);

        //获取当前timestamp类型的时间
        java.util.Date date = new java.util.Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        Timestamp orderCreatTime =timeStamp;
        Timestamp orderPayTime =timeStamp;
        Order order = (Order) ContextUtil.getBean("order");
        order.build(0,
                orderEncoding,
                orderSiteId,
                routeName,
                accoutUserName,
                orderTotalPrice,
                orderReducePrice,
                orderActualPrice,
                orderCreatTime,
                orderPayTime,
                orderNote);
        orderService.createOrder(order);
        return "Success";
    }


    @GetMapping("/getorder")
    @ApiOperation(value = "根据accoutname获得所有订单")
    public List<Order> getOorder(String name){return orderService.selectOrderByUsername(name);}
}

