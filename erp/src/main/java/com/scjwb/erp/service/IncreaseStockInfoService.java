package com.scjwb.erp.service;

import com.scjwb.erp.model.IncreaseStockInfo;

public interface IncreaseStockInfoService {
    void validRequestParam(IncreaseStockInfo increaseStockInfo);

    int increaseStock(IncreaseStockInfo increaseStockInfo);
}
