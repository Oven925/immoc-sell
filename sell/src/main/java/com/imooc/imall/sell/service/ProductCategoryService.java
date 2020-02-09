package com.imooc.imall.sell.service;

import com.imooc.imall.sell.bean.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    int save(ProductCategory productCategory);

}
