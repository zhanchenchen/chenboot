package com.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot启动类
 */
@SpringBootApplication
@MapperScan(value = {"com.learn.dao"})  //扫描dao数据接口包
@EnableTransactionManagement    // 开启事务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
