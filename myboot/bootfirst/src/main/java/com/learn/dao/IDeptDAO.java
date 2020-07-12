package com.learn.dao;

import com.learn.model.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IDeptDAO {
    /**
     * 查找所有部门信息
     * @return 部门信息集合
     */
    List<Dept> findAll();
}
