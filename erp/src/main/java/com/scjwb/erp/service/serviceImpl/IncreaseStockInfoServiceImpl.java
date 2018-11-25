package com.scjwb.erp.service.serviceImpl;

import com.scjwb.erp.dao.IncreaseStockInfoMapper;
import com.scjwb.erp.model.IncreaseStockInfo;
import com.scjwb.erp.service.IncreaseStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IncreaseStockInfoServiceImpl implements IncreaseStockInfoService{
    @Autowired
    private IncreaseStockInfoMapper increaseStockInfoMapper;
    @Override
    public void validRequestParam(IncreaseStockInfo increaseStockInfo) {
        String pricingMethod = increaseStockInfo.getPricingMethod();
        BigDecimal weight = increaseStockInfo.getWeight();
        if ("1".equals(pricingMethod)&&weight == null){
            throw new RuntimeException("按重量计价时，商品重量为必填项！");
        }
    }

    @Override
    public int increaseStock(IncreaseStockInfo increaseStockInfo) {
        int insert = increaseStockInfoMapper.insert(increaseStockInfo);
        return insert;
    }
}
