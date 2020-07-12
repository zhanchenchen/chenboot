package com.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;

@RestController
@Slf4j
public class InternalObjectController {
    @GetMapping("object")
   public String  object(String message,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //————————————————request——————————————————
        System.err.println("***getRemoteAddr客户端IP地址***："+request.getRemoteAddr());
        System.err.println("***getCharacterEncoding客户端请求编码***："+request.getCharacterEncoding());
        System.err.println("***取得sessionId***："+request.getSession().getId());
        System.err.println("***getRealPath取得一个目录的真实路径***："+request.getServletContext().getRealPath("/zcc"));
        System.err.println("***getContextPath取得上下文路径***："+request.getServletContext().getContextPath());
        System.err.println("***getServletPath取得请求调用的servlet地址***："+request.getServletPath());
        System.err.println("***getHeader取得头信息中的Cookie***："+ request.getHeader("Cookie"));
        System.err.println("***getRequestURL取得请求服务器地址***："+request.getRequestURL());
        System.err.println("***getServerName取得请求服务器名称***："+request.getServerName());
        System.err.println("***getServerPort取得请求服务器端口***："+request.getServerPort());
        Enumeration<String> headerNames = request.getHeaderNames();
//        Iterator<String> stringIterator = headerNames.asIterator();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            System.err.println("header:"+header);
        }
        System.err.println("***getPathInfo取得路径信息***："+request.getPathInfo());
        System.err.println("***getMethod取得请求方法***："+request.getMethod());
        System.err.println("***getAuthType取得认证类型***："+request.getAuthType());

        //————————————————response——————————————————
        System.err.println("***响应状态码***："+response.getStatus());
        response.setCharacterEncoding("UTF-8");
        System.err.println("***获得响应编码***："+response.getCharacterEncoding());
        return message;
   }
}
