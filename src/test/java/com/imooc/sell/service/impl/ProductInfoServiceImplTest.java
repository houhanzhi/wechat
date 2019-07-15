package com.imooc.sell.service.impl;

import com.imooc.sell.dao.ProductInfoDao;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoServiceImpl;

    @Test
    public void findOne() {
        ProductInfo one = productInfoServiceImpl.findOne("123456");
        Assert.assertNotNull(one);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productInfoServiceImpl.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(1,10);
        Page<ProductInfo> all = productInfoServiceImpl.findAll(pageRequest);
        System.out.println(all.getTotalElements());
        Assert.assertNotEquals(0, all.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("654321");
        productInfo.setProductName("小米粥");
        productInfo.setProductPrice(new BigDecimal(2.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很喜欢的粥");
        productInfo.setProductIcon("http://yyyy.jpg");
        productInfo.setProductStatus(ProductStatus.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productInfoServiceImpl.save(productInfo);
        Assert.assertNotNull(result);
    }
}