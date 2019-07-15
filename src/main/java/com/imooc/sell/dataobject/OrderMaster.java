package com.imooc.sell.dataobject;


import com.imooc.sell.enums.OrderStatus;
import com.imooc.sell.enums.PayStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@DynamicUpdate//自动更新时间
@Data
public class OrderMaster {

    //订单id
    @Id
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
    private Integer orderStatus = OrderStatus.NEW.getCode();
    //支付状态 默认0为未支付
    private Integer payStatus = PayStatus.WAIT.getCode();

    //按订单时间进行排序
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

//    @Transient//该注解在对象与表对应时中可忽略
//    private List<OrderDetail> orderDetailList;
}
