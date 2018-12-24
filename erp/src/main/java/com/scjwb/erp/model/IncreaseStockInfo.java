package com.scjwb.erp.model;

import java.math.BigDecimal;
import java.util.Date;

public class IncreaseStockInfo {
    private Integer id;

    private String stockId;

    private String productId;

    private BigDecimal weight;

    private String weightUnit;

    private Integer count;

    private String countUnit;

    private BigDecimal price;

    private String pricingMethod;

    private String stockType;

    private String addressId;

    private Date createTime;

    private BigDecimal allAmount;



    public IncreaseStockInfo(Integer id, String stockId, String productId, BigDecimal weight, String weightUnit, Integer count, String countUnit, BigDecimal price, String pricingMethod, String stockType, String addressId, Date createTime) {
        this.id = id;
        this.stockId = stockId;
        this.productId = productId;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.count = count;
        this.countUnit = countUnit;
        this.price = price;
        this.pricingMethod = pricingMethod;
        this.stockType = stockType;
        this.addressId = addressId;
        this.createTime = createTime;
    }

    public IncreaseStockInfo() {
        super();
    }
    public BigDecimal getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(BigDecimal allAmount) {
        this.allAmount = allAmount;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit == null ? null : weightUnit.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCountUnit() {
        return countUnit;
    }

    public void setCountUnit(String countUnit) {
        this.countUnit = countUnit == null ? null : countUnit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPricingMethod() {
        return pricingMethod;
    }

    public void setPricingMethod(String pricingMethod) {
        this.pricingMethod = pricingMethod == null ? null : pricingMethod.trim();
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType == null ? null : stockType.trim();
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}