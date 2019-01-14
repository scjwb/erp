package com.scjwb.erp.dao;

import com.scjwb.erp.model.CategoryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryInfo record);

    int insertSelective(CategoryInfo record);

    CategoryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryInfo record);

    int updateByPrimaryKey(CategoryInfo record);

    List<CategoryInfo> selectByPid(String parentId);

    int selectByCategoryName(String categoryName);

    List<String> selectPidListByProductName(String productName);
}