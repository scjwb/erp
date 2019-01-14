package com.scjwb.erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scjwb.erp.bean.Result;
import com.scjwb.erp.model.IncreaseStockInfo;
import com.scjwb.erp.model.ReduceStockInfo;
import com.scjwb.erp.service.IncreaseStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {
    @Autowired
    private IncreaseStockInfoService increaseStockInfoService;
    //商品入库
    @RequestMapping(value = "increaseStock",method = RequestMethod.POST)
    public Result increaseStock(@RequestBody IncreaseStockInfo increaseStockInfo){
        try {
            //验证入库商品信息是否符合逻辑
            increaseStockInfoService.validIncreaseStockParam(increaseStockInfo);
            int count = increaseStockInfoService.increaseStock(increaseStockInfo);
            return Result.success("成功插入"+count+"条入库记录！");

        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    //查询商品入库记录
    @RequestMapping(value = "showIncreaseRecord",method = RequestMethod.GET)
    public Result showIncreaseRecord(Integer pageNum,Integer pageSize,String startDate,String endDate,String productName,IncreaseStockInfo increaseStockInfo){
        try {
            //查询商品入库记录
            PageHelper.startPage(pageNum,pageSize);
            List<HashMap> increaseRecord = increaseStockInfoService.showIncreaseByCondition(startDate,endDate,productName,increaseStockInfo);
            PageInfo<HashMap> pageInfo = new PageInfo<>(increaseRecord);
            return Result.success(pageInfo);

        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    //校验出库商品id，并返回商品的相关信息
    @RequestMapping(value = "validStockId",method = RequestMethod.GET)
    public Result validStockId(@RequestParam(required = true) String stockId){
        try {
            //验证出库商品信息是否符合逻辑
            HashMap<String,Object> stockMap = increaseStockInfoService.validReduceStockParam(stockId);
            Result<HashMap<String, Object>> success = Result.success(stockMap);
            success.setMessage("该入库编号id符合出库要求！");
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    //商品出库
    @RequestMapping(value = "reduceStock",method = RequestMethod.POST)
    public Result reduceStock(@RequestBody ReduceStockInfo reduceStockInfo){
        try {
            //验证入库商品信息是否符合逻辑
            HashMap<String, Object> stockMap = increaseStockInfoService.validReduceStockParam(reduceStockInfo.getStockId());
            int count = increaseStockInfoService.reduceStock(reduceStockInfo);
            return Result.success("成功插入"+count+"条入库记录！");

        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    //查询商品出库记录
    @RequestMapping(value = "showReduceRecord",method = RequestMethod.GET)
    public Result showReduceRecord(Integer pageNum,Integer pageSize,String startDate,String endDate,ReduceStockInfo reduceStockInfo ){
        try {
            //查询商品出库记录
            PageHelper.startPage(pageNum,pageSize);
            List<HashMap> reduceRecord = increaseStockInfoService.showReduceByCondition(startDate,endDate,reduceStockInfo);
            PageInfo<HashMap> pageInfo = new PageInfo<>(reduceRecord);
            return Result.success(pageInfo);

        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
