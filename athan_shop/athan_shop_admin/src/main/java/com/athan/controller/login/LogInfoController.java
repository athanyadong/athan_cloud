package com.athan.controller.login;


import com.athan.service.LogInfoService;
import com.athan.user.model.LogInfo;
import com.athan.util.web.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @aurhor yyh
 * @description 登录信息保存
 * @date 2022/7/13 16:55
 */
@RestController
@RequestMapping("login")
public class LogInfoController {

    @Resource
    private LogInfoService logInfoService;

    @PostMapping("/logininfor")
    public AjaxResult saveLogininfor(@RequestBody LogInfo sysLogininfor){
     return    logInfoService.saveLogininfor(sysLogininfor);
    }

}
