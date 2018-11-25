package com.scjwb.erp.dao;

import com.scjwb.erp.model.IncreaseStockInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IncreaseStockInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncreaseStockInfo record);

    int insertSelective(IncreaseStockInfo record);

    IncreaseStockInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncreaseStockInfo record);

    int updateByPrimaryKey(IncreaseStockInfo record);
}