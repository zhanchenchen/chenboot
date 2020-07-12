package com.learn.Service.impl;

import com.learn.Service.IDeptService;
import com.learn.dao.IDeptDAO;
import com.learn.model.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll();
    }
}
