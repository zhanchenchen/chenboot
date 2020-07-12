package com.learn.Service;

import com.learn.model.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDeptService {
    /**
     * 查找所有部门信息
     * @return 部门信息集合
     */
    List<Dept> list();
}
