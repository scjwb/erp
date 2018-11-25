package com.scjwb.erp.controller;

import com.scjwb.erp.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login_page")
    @ResponseBody
    public Result loginPage(){
        return Result.fail("尚未登陆，请先登录!");
    }
    @RequestMapping("/logout_page")
    @ResponseBody
    public Result logoutPage(){
        return Result.success("已成功注销");
    }
    @RequestMapping("/admin/test")
    @ResponseBody
    public Result adminTest(){
        return Result.success("管理员权限测试成功");
    }
}
