package com.scjwb.erp.controller;

import com.scjwb.erp.bean.Result;
import com.scjwb.erp.model.CategoryInfo;
import com.scjwb.erp.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categoryInfo")
public class CategoryController {
    @Autowired
    private CategoryInfoService categoryInfoService;
    @RequestMapping(value = "showAllCategory",method = RequestMethod.GET)
    public Result showAllCategory(){
        try {
            List<CategoryInfo> categorys = categoryInfoService.showAllCategory();
            Result<List> success = Result.success(categorys);
            success.setMessage("查询成功！");
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    @RequestMapping(value = "createCategory",method = RequestMethod.POST)
    public Result createCategory(@RequestBody CategoryInfo categoryInfo){
        try {
            CategoryInfo category = categoryInfoService.createCategory(categoryInfo);
            Result<CategoryInfo> success = Result.success(category);
            success.setMessage("添加成功！");
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    @RequestMapping("selectCategoryByParentId")
    public Result selectCategoryByParentId(String parentId){
        try {
            List<CategoryInfo> categoryInfos = categoryInfoService.selectCategoryByParentId(parentId);
            Result<List<CategoryInfo>> success = Result.success(categoryInfos);
            success.setMessage("查询成功！");
            return success ;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
    @RequestMapping(value = "updateCategoryById",method = RequestMethod.POST)
    public Result updateCategoryById(@RequestBody CategoryInfo categoryInfo){
            int count = categoryInfoService.updateCategory(categoryInfo);
            if (count>0){
                Result<CategoryInfo> success = Result.success(categoryInfo);
                success.setMessage("更新成功！");
                return success;
            }else {
                return Result.fail("更新失败，未找到相关记录！");

            }
    }
    @RequestMapping("deleteCategoryById")
    public Result deleteCategoryById(Integer id){
        try {
            int count = categoryInfoService.deleteByCategoryId(id);
            if (count>0){
                Result<Integer> success = Result.success(id);
                success.setMessage("删除成功！");
                return success;
            }else {
            return Result.fail("删除失败，未找到相关记录！");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
