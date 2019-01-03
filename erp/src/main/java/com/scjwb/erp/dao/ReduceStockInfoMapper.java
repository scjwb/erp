package com.scjwb.erp.dao;

import com.scjwb.erp.model.ReduceStockInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReduceStockInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReduceStockInfo record);

    int insertSelective(ReduceStockInfo record);

    ReduceStockInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReduceStockInfo record);

    int updateByPrimaryKey(ReduceStockInfo record);

    List<ReduceStockInfo> checkIfReduced(String stockId);
}