package com.imooc.imall.sell.controller;

import com.imooc.imall.sell.bean.ProductCategory;
import com.imooc.imall.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

//    @RequestMapping("getAllProductCategory")
//    @ResponseBody
//    public List<ProductCategory> getAllUser(){
//        //获取所有数据
//        List<ProductCategory> productCategories = productCategoryService.getAllProductCategory();
//        return productCategories;
//    }
//
//    @RequestMapping("updateProductCategory")
//    @ResponseBody
//    public int updateProductCategory(){
//        //获取所有数据
//        return  productCategoryService.updateProductCategory();
//    }

}
