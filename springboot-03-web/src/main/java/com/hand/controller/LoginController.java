package com.hand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

/**
 * @Author ludongpeng
 * @Date 2020/12/12 14:40
 * @Description:
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){

        if (!StringUtils.isEmpty(username) && "123".equals(password)){
            return "index";
        }else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "sign-in";
        }
    }
}
