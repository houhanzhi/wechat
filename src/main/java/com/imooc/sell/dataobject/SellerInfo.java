package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SellerInfo {

    //卖家id
    @Id
    private String seller_id;
    //用户名
    private String username;
    //密码
    private String password;
    //微信openId
    private String openid;
}
