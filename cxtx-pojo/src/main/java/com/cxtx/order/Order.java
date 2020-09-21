package com.cxtx.order;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@Scope(scopeName = "prototype")
@Data
public class Order {
    private int orderId;
    private String orderEncoding;
    private int orderSiteId;
    private String routeName;
    private String accountUsername;
    private float orderTotalPrice;
    private float orderReducePrice;
    private float orderActualPrice;
    private Timestamp orderCreatTime;
    private Timestamp orderPayTime;
    private String orderNote;


    public void build(int orderId, String orderEncoding, int orderSiteId, String routeName, String accountUsername, float orderTotalPrice, float orderReducePrice, float orderActualPrice, Timestamp orderCreatTime, Timestamp orderPayTime, String orderNote) {
        this.orderId = orderId;
        this.orderEncoding = orderEncoding;
        this.orderSiteId = orderSiteId;
        this.routeName = routeName;
        this.accountUsername = accountUsername;
        this.orderTotalPrice = orderTotalPrice;
        this.orderReducePrice = orderReducePrice;
        this.orderActualPrice = orderActualPrice;
        this.orderCreatTime = orderCreatTime;
        this.orderPayTime = orderPayTime;
        this.orderNote = orderNote;
    }

}











