package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatus;
import com.imooc.sell.enums.PayStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1556170868774785802";

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("侯涵之");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("123456789123");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(1);

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("2222");
        orderDetail1.setProductQuantity(100);

        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail1);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderServiceImpl.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderServiceImpl.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() {

        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderDTO> list = orderServiceImpl.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0, list.getTotalElements());

    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO result = orderServiceImpl.cancel(orderDTO);
        Assert.assertEquals(OrderStatus.CANCEL.getCode(), result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO result = orderServiceImpl.finish(orderDTO);
        Assert.assertEquals(OrderStatus.FINISHED.getCode(), result.getOrderStatus());

    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO result = orderServiceImpl.paid(orderDTO);
        Assert.assertEquals(PayStatus.SUCCESS.getCode(), result.getPayStatus());

    }
}