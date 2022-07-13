package com.athan;

import com.athan.service.LoginService;
import com.athan.util.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 18:10
 */
@RestController
@RequestMapping("auth")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("login")
    public AjaxResult login(String userName, String passWord) {
        return loginService.login(userName, passWord);
    }
}