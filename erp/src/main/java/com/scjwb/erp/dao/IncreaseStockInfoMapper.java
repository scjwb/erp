package com.scjwb.erp.dao;

import com.scjwb.erp.model.IncreaseStockInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface IncreaseStockInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncreaseStockInfo record);

    int insertSelective(IncreaseStockInfo record);

    IncreaseStockInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncreaseStockInfo record);

    int updateByPrimaryKey(IncreaseStockInfo record);

    List<HashMap> selectByIncreaseStockInfo(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("pidList") List<String> pidList, @Param("increaseStockInfo") IncreaseStockInfo increaseStockInfo);

    IncreaseStockInfo selectByIncreaseStockId(String stockId);
}