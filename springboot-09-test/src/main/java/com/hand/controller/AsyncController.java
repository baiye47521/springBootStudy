package com.hand.controller;

import com.hand.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ludongpeng
 * @Date 2020/12/17 16:05
 * @Description:
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hand")
    public String hand(){
        asyncService.hand();
        return "ok";
    }
}
