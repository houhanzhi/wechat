package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * dto:数据传输对象
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)//如果返回的参数为null,则在返回的njson中可将其忽略
public class OrderDTO {

    //订单id
    private String orderId;
    //卖家名字
    private String buyerName;
    //买家电话
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信openId
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态 默认0为新下单
    private Integer orderStatus;
    //支付状态 默认0为未支付
    private Integer payStatus;

    //按订单时间进行排序
    //创建时间
    //要求返回的为时间戳/秒，实际返回的为毫秒，需要将Date--->Long
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    //"orderDetailList": null
    private List<OrderDetail> orderDetailList;

    //"orderDetailList": []---->只需给该成员赋一个初始值
    //private List<OrderDetail> orderDetailList = new ArrayList<>();

}
