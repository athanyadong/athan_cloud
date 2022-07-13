package com.athan.controller.user;

import com.athan.doman.R;
import com.athan.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 17:22
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("getUserInfo/{username}")
    public R selectUserByUserName(@PathVariable("username") String username){
        R r = sysUserService.selectUserByUserName(username);
        return R.ok(r);
    }
}
