package com.imooc.imall.sell.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.imall.sell.bean.ProductInfo;
import com.imooc.imall.sell.enums.ProductStatusEnum;
import com.imooc.imall.sell.mapper.ProductInfoMapper;
import com.imooc.imall.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProductInfoImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper infoMapper;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(productId);
        return infoMapper.selectOne(productInfo);
    }


    /**
     * 查询在架商品
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return infoMapper.select(productInfo);
    }

    @Override
    public PageInfo<ProductInfo> findAll() {
        PageHelper.startPage(1, 10).setOrderBy("id desc");
        final PageInfo<ProductInfo> userPageInfo = new PageInfo<>(this.infoMapper.selectAll());
        return userPageInfo;
    }

    @Override
    public int save(ProductInfo productInfo) {
       int num = infoMapper.insert(productInfo);
       return  num;
    }


}
