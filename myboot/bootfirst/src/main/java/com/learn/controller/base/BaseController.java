package com.learn.controller.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
public abstract class BaseController {
    @Autowired
    private MessageSource messageSource;    //注入资源对象

    /**
     * 获取资源信息key所对应的value值
     * @param key key值
     * @param args 占位符参数
     * @return value值
     */
    public String getMessage(String key,String ... args){
        return this.messageSource.getMessage(key,args, Locale.getDefault());
    }

    /**
     * 接收前台日期类转换
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,true));
    }
}
