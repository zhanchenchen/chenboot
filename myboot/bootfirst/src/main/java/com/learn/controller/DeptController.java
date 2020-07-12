package com.learn.controller;

import com.learn.Service.IDeptService;
import com.learn.controller.base.BaseController;
import com.learn.model.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/dept")
public class DeptController extends BaseController {
    @Autowired
    private IDeptService deptService;
    @GetMapping("/list")
    public Object list(){
        List<Dept> list = this.deptService.list();
        return list;
    }
}
