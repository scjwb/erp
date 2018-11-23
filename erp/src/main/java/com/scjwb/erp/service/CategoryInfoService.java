package com.scjwb.erp.service;

import com.scjwb.erp.model.CategoryInfo;

import java.util.List;

public interface CategoryInfoService {
    CategoryInfo createCategory(CategoryInfo categoryInfo) throws Exception;

    List<CategoryInfo> selectCategoryByParentId(String parentId);
}
