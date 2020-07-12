package com.learn.controller;

import com.learn.controller.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestMessageController extends BaseController {

    @GetMapping("message")
    public String message(String mid){
        System.err.println(super.getMessage("user.add.action"));
        System.err.println(super.getMessage("welcome.msg",mid));
        return super.getMessage("welcome.msg",mid);
    }
}
