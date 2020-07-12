package com.learn.controller;

import com.learn.model.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ResponseController {
    @RequestMapping("/test")
    public ResponseResult test(){
        return ResponseResult.success();
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public ResponseResult test2(@RequestParam(name = "message",defaultValue = "你好") String message){
        return ResponseResult.success(message,"嘿嘿");
    }

    @GetMapping("/test3/{msg}")
    public ResponseResult test3(@PathVariable(name = "msg") String message){
        return ResponseResult.error(message,"嘿嘿");
    }
}
