package com.imooc.imall.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

    public ProductVO() {
    }

    public ProductVO(String categoryName, Integer categoryType, List<ProductInfoVO> productInfoVOList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.productInfoVOList = productInfoVOList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getProductInfoVOList() {
        return productInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        this.productInfoVOList = productInfoVOList;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", productInfoVOList=" + productInfoVOList +
                '}';
    }
}
