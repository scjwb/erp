package com.scjwb.erp.service;

import com.scjwb.erp.model.IncreaseStockInfo;
import com.scjwb.erp.model.ReduceStockInfo;

import java.util.HashMap;
import java.util.List;

public interface IncreaseStockInfoService {
    void validIncreaseStockParam(IncreaseStockInfo increaseStockInfo);

    int increaseStock(IncreaseStockInfo increaseStockInfo);

    List<HashMap> showIncreaseByCondition(String startDate, String endDate, IncreaseStockInfo increaseStockInfo);

    int reduceStock(ReduceStockInfo reduceStockInfo);

    HashMap<String, Object> validReduceStockParam(String stockId);

    List<HashMap> showReduceByCondition(String startDate, String endDate, ReduceStockInfo reduceStockInfo);
}
