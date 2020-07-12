package com.learn.controller;

import com.learn.controller.base.BaseController;
import com.learn.model.ResponseResult;
import com.learn.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.stream.Collectors;

@Controller
@Slf4j
@Validated  //验证基本类型请求参数
public class UserController extends BaseController {

    @GetMapping("addPre")
    public String addPre(){
        return "user_add";
    }

    @PostMapping("add")
    @ResponseBody
    public Object add(@Valid User user){
        return ResponseResult.success(user);
    }

//    @PostMapping("add")
//    @ResponseBody
//    public Object add(@Valid User user, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            String errorMessage = bindingResult.getAllErrors().stream()
//                    .map(ObjectError::getDefaultMessage)
//                    .collect(Collectors.joining(","));
//            return errorMessage;
//        }
//        return user;
//

    @GetMapping("echo_message")
    @ResponseBody
    public Object setAttribute(@NotBlank(message = "message不能为空！")String msg,
                               @Max(value = 30,message = "数量过大！") int amount){
        return ResponseResult.success((Object)("[ECHO:]"+msg));
    }
}
