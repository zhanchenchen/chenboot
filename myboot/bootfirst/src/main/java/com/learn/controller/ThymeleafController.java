package com.learn.controller;

import com.learn.controller.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * thymeleaf模板渲染测试
 */
@Controller
@Slf4j
public class ThymeleafController extends BaseController {

    @GetMapping("show")
    public String show(String msg, Model model) {
        model.addAttribute("url", "www.baidu.com");
        model.addAttribute("msg", msg);
        return "message/message_show";
    }
}
