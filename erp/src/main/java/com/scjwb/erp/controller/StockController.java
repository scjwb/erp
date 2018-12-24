package com.scjwb.erp.controller;

import com.scjwb.erp.bean.Result;
import com.scjwb.erp.model.IncreaseStockInfo;
import com.scjwb.erp.service.IncreaseStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {
    @Autowired
    private IncreaseStockInfoService increaseStockInfoService;
    @RequestMapping(value = "increaseStock",method = RequestMethod.POST)
    public Result increaseStock(@RequestBody IncreaseStockInfo increaseStockInfo){
        try {
            //验证入库商品信息是否符合逻辑
            increaseStockInfoService.validRequestParam(increaseStockInfo);
            int count = increaseStockInfoService.increaseStock(increaseStockInfo);
            return Result.success("成功插入"+count+"条入库记录！");

        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
