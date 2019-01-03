package com.scjwb.erp.service.serviceImpl;

import com.scjwb.erp.dao.IncreaseStockInfoMapper;
import com.scjwb.erp.dao.ReduceStockInfoMapper;
import com.scjwb.erp.model.IncreaseStockInfo;
import com.scjwb.erp.model.ReduceStockInfo;
import com.scjwb.erp.service.IncreaseStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncreaseStockInfoServiceImpl implements IncreaseStockInfoService{
    private static String singleStock = "0"; //单条入库
    private static String multiStock = "1"; //多条入库
    private static String priceByCount = "0"; //按数量计价
    private static String priceByWeight = "1"; //按重量计价
    @Autowired
    private IncreaseStockInfoMapper increaseStockInfoMapper;
    @Autowired
    private ReduceStockInfoMapper reduceStockInfoMapper;
    @Override
    public void validRequestParam(IncreaseStockInfo increaseStockInfo) {
        BigDecimal allAmount = null;
        //参数非空校验
        String stockId = increaseStockInfo.getStockId();
        if (stockId == null){
            throw new RuntimeException("入库编码不能为空！");
        }
        String productId = increaseStockInfo.getProductId();
        if (productId == null){
            throw new RuntimeException("商品分类不能为空！");
        }
        //入库方式验证
        String stockType = increaseStockInfo.getStockType(); //入库方式
        Integer count = increaseStockInfo.getCount();//库存数量
        if (singleStock.equals(stockType)){
            //单条入库时商品数量只能是1；
            increaseStockInfo.setCount(1);
        }else if (multiStock.equals(stockType)){
            if(count == null || count<=0){
                throw new RuntimeException("多条入库时，请传入正确的商品数量！");
            }
        }else {
            throw new RuntimeException("请选择正确的入库方式！");
        }
        //商品单价正确性验证
        BigDecimal price = increaseStockInfo.getPrice();
        if (price == null || price.doubleValue()<=0){
            throw new RuntimeException("请填写正确的商品价格！");
        }
        //计价方式验证
        String pricingMethod = increaseStockInfo.getPricingMethod();
        BigDecimal weight = increaseStockInfo.getWeight();
        if (priceByWeight.equals(pricingMethod)){
            if(weight == null||weight.doubleValue()<=0){
                throw new RuntimeException("按重量计价时，请传入正确的商品重量！");
            }
            allAmount = weight.multiply(price);
        }else if (priceByCount.equals(pricingMethod)){
            allAmount = price.multiply(BigDecimal.valueOf(count));
        }else {
            throw new RuntimeException("请选择正确的计价方式！");
        }
        //计算入库商品总价
        increaseStockInfo.setAllAmount(allAmount);
        increaseStockInfo.setCreateTime(new Date());
    }

    @Override
    public int increaseStock(IncreaseStockInfo increaseStockInfo) {
        int insert = increaseStockInfoMapper.insert(increaseStockInfo);
        return insert;
    }

    @Override
    public List<HashMap> showIncreaseByCondition(String startDate, String endDate, IncreaseStockInfo increaseStockInfo) {
        List<HashMap> increaseStockInfos = increaseStockInfoMapper.selectByIncreaseStockInfo(startDate,endDate,increaseStockInfo);
        return increaseStockInfos;
    }

    @Override
    public int reduceStock(ReduceStockInfo reduceStockInfo) {
        return 0;
    }

    @Override
    public HashMap<String, Object> validRequestParam(String stockId) {
        HashMap<String, Object> stockMap = new HashMap<>();
        IncreaseStockInfo increaseStockInfo = increaseStockInfoMapper.selectByIncreaseStockId(stockId);
        if (increaseStockInfo == null){
            throw new RuntimeException("该商品编号不存在！");
        }
        //验证必填参数项
        String pricingMethod = increaseStockInfo.getPricingMethod();
        String stockType = increaseStockInfo.getStockType();
        Integer count = increaseStockInfo.getCount();
        BigDecimal weight = increaseStockInfo.getWeight();

        List<ReduceStockInfo> reduceRecords = reduceStockInfoMapper.checkIfReduced(stockId);
        if (singleStock.equals(stockType)){
            //单条入库时检查该商品是否已经被卖出
            if (reduceRecords!=null && reduceRecords.size()>0){
                if (reduceRecords.stream().anyMatch(reduceStockInfo -> !"1".equals(reduceStockInfo.getStatus()))){
                    throw new RuntimeException("该商品已卖出或失效！");
                }
            }
            stockMap.put("stockCount",1);
            stockMap.put("stockWeight", weight.doubleValue());
        }else if (multiStock.equals(stockType)){
            Integer reduceCount = 0;
            if (priceByCount.equals(pricingMethod)){
                //按数量计价
                if (reduceRecords!=null && reduceRecords.size()>0){
                    reduceCount = reduceRecords.stream().filter(reduceStockInfo -> !"1".equals(reduceStockInfo.getStatus())).collect(Collectors.summingInt(ReduceStockInfo::getCount));
                    if (reduceCount>=count){
                        throw new RuntimeException("该商品已卖完！");
                    }
                }
                stockMap.put("stockCount",count-reduceCount);
            }else if (priceByWeight.equals(pricingMethod)){
                //按重量计价
                Double reduceWeight = 0.0;
                if (reduceRecords!=null && reduceRecords.size()>0){
                    reduceCount = reduceRecords.stream().filter(reduceStockInfo -> !"1".equals(reduceStockInfo.getStatus())).collect(Collectors.summingInt(ReduceStockInfo::getCount));
                    if (reduceCount>=count){
                        throw new RuntimeException("该商品已卖完！");
                    }
                    reduceWeight = reduceRecords.stream().filter(reduceStockInfo -> !"1".equals(reduceStockInfo.getStatus())).collect(Collectors.summingDouble(reduceStockInfo -> reduceStockInfo.getWeight().doubleValue()));
                    if (reduceWeight>=weight.doubleValue()){
                        throw new RuntimeException("该商品已卖完！");
                    }
                }
                stockMap.put("stockCount",count-reduceCount);
                stockMap.put("stockWeight", weight.doubleValue()-reduceWeight);
            }
        }
        return stockMap;
    }

    @Override
    public List<HashMap> showReduceByCondition(String startDate, String endDate, ReduceStockInfo reduceStockInfo) {
        return null;
    }

}
