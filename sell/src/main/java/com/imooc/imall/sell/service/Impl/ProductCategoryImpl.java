package com.imooc.imall.sell.service.Impl;

import com.imooc.imall.sell.bean.ProductCategory;
import com.imooc.imall.sell.mapper.ProductCategoryMapper;
import com.imooc.imall.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductCategoryImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(categoryId);
        return  productCategoryMapper.selectOne(productCategory);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.selectAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> productCategories = new ArrayList<>();
        for (Integer i: categoryTypeList) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setCategoryId(i);
            ProductCategory p = productCategoryMapper.selectOne(productCategory);
            productCategories.add(p);
        }
        return productCategories;
    }

    @Override
    public int save(ProductCategory productCategory) {
        return productCategoryMapper.insert(productCategory);
    }

//    @Override
//    public List<ProductCategory> getAllProductCategory() {
//        return productCategoryMapper.selectAll();
//    }
//
//    @Override
//    public int updateProductCategory() {
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(1);
//        productCategory.setCategoryType(100);
//        int num =  productCategoryMapper.updateByPrimaryKeySelective(productCategory);
//
//        return  num;
//    }
//
//    @Override
//    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
//        Example e = new Example(ProductCategory.class);
//
//        List<Integer> list = Arrays.asList(1);
//
//        return null;
//    }


}
