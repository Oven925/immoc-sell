package com.imooc.imall.sell.service;


import com.github.pagehelper.PageInfo;
import com.imooc.imall.sell.bean.ProductInfo;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductInfoService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    PageInfo<ProductInfo> findAll();


    int save(ProductInfo productInfo);



    //加库存

    //减库存

}
