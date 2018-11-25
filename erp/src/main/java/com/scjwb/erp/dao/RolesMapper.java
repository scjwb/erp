package com.scjwb.erp.dao;

import com.scjwb.erp.model.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    List<Roles> selectRolesByUserId(Integer userId);
}