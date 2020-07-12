package com.learn.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门数据类
 */
@Data
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;
}
