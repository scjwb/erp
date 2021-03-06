package com.scjwb.erp.service.serviceImpl;

import com.mysql.jdbc.StringUtils;
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
        String categoryName = categoryInfo.getCategoryName();
        if (StringUtils.isNullOrEmpty(categoryName)||StringUtils.isNullOrEmpty(parentId)){
            throw new RuntimeException("参数不能为空！");
        }
        int categoryCount = categoryInfoMapper.selectByCategoryName(categoryName);
        if (categoryCount>0){
            throw new RuntimeException("该名称已存在！");
        }
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

    @Override
    public int updateCategory(CategoryInfo categoryInfo) {
        int count = categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo);
        return count;
    }

    @Override
    public int deleteByCategoryId(Integer id) throws Exception{
        List<CategoryInfo> categoryInfos = categoryInfoMapper.selectByPid(id.toString());
        if (categoryInfos != null && categoryInfos.size()>0){
            throw new RuntimeException("删除分类前，请先清空该分类下所有子分类！");
        }
        int count = categoryInfoMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public List<CategoryInfo> showAllCategory() {
        List<CategoryInfo> categoryInfos = findChildrenByParentId("0");
        return categoryInfos;
    }

    private List<CategoryInfo> findChildrenByParentId(String parentId) {
        List<CategoryInfo> categoryInfos = categoryInfoMapper.selectByPid(parentId);
        if (categoryInfos != null && categoryInfos.size()>0){
            for (CategoryInfo categoryInfo:categoryInfos){
                String parentId2 = categoryInfo.getId().toString();
                List<CategoryInfo> childrenByParentId = findChildrenByParentId(parentId2);
                categoryInfo.setChildren(childrenByParentId);
            }
        }else {
            return null;
        }
        return categoryInfos;
    }
}
