package com.scjwb.erp.controller;

import com.scjwb.erp.bean.Result;
import com.scjwb.erp.dao.CategoryInfoMapper;
import com.scjwb.erp.model.CategoryInfo;
import com.scjwb.erp.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categoryInfo")
public class CategoryController {
    @Autowired
    private CategoryInfoService categoryInfoService;
    @RequestMapping(value = "createCategory")
    public Result createCategory(CategoryInfo categoryInfo){
        try {
            CategoryInfo category = categoryInfoService.createCategory(categoryInfo);
            return Result.success(category);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    @RequestMapping("selectCategoryByParentId")
    public Result selectCategoryByParentId(String parentId){
        try {
            List<CategoryInfo> categoryInfos = categoryInfoService.selectCategoryByParentId(parentId);
            return Result.success(categoryInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
