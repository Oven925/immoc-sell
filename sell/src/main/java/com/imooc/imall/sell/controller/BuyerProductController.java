package com.imooc.imall.sell.controller;


import com.imooc.imall.sell.Utils.ResultVOUtils;
import com.imooc.imall.sell.VO.ProductInfoVO;
import com.imooc.imall.sell.VO.ProductVO;
import com.imooc.imall.sell.VO.ResultVO;
import com.imooc.imall.sell.bean.ProductCategory;
import com.imooc.imall.sell.bean.ProductInfo;
import com.imooc.imall.sell.service.ProductCategoryService;
import com.imooc.imall.sell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.com.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductInfoService infoService;

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1. 查询所有上架商品
        List<ProductInfo> productInfoList = infoService.findUpAll();

        //2.查询类目
        //传统做法
        List<Integer> categoryType = new ArrayList<>();
        for (ProductInfo info: productInfoList) {
            categoryType.add(info.getCategoryType());
        }

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryType);
        //精简做法

        //3.数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);

        return ResultVOUtils.success(productVOList);
    }

}
