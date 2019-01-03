package com.scjwb.erp.model;

import java.math.BigDecimal;
import java.util.Date;

public class ReduceStockInfo {
    private Integer id;

    private String stockId;

    private String productId;

    private BigDecimal weight;

    private Integer count;

    private BigDecimal price;

    private BigDecimal allamount;

    private String status;

    private Date createTime;

    public ReduceStockInfo(Integer id, String stockId, String productId, BigDecimal weight, Integer count, BigDecimal price, BigDecimal allamount, String status, Date createTime) {
        this.id = id;
        this.stockId = stockId;
        this.productId = productId;
        this.weight = weight;
        this.count = count;
        this.price = price;
        this.allamount = allamount;
        this.status = status;
        this.createTime = createTime;
    }

    public ReduceStockInfo() {
        super();
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAllamount() {
        return allamount;
    }

    public void setAllamount(BigDecimal allamount) {
        this.allamount = allamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}