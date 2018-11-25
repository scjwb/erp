package com.scjwb.erp.service.serviceImpl;

import com.scjwb.erp.dao.CategoryInfoMapper;
import com.scjwb.erp.model.CategoryInfo;
import com.scjwb.erp.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryInofServiceImpl implements CategoryInfoService{
    @Autowired
    private CategoryInfoMapper categoryInfoMapper;
    @Override
    public CategoryInfo createCategory(CategoryInfo categoryInfo) throws Exception{
        String parentId = categoryInfo.getParentId();
        if (!"0".equals(parentId)){

            CategoryInfo parent = categoryInfoMapper.selectByPrimaryKey(Integer.parseInt(parentId));
            if (parent==null){
                throw new RuntimeException("传入父类id有误！请检查后重新请求！");
            }
        }
        categoryInfoMapper.insert(categoryInfo);
        return categoryInfo;
    }

    @Override
    public List<CategoryInfo> selectCategoryByParentId(String parentId) {
        List<CategoryInfo> parents = categoryInfoMapper.selectByPid(parentId);
        return parents;
    }
}
