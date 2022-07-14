package com.athan.service;


import com.athan.user.model.LogInfo;
import com.athan.util.web.AjaxResult;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 16:43
 */
public interface LogInfoService {
    //保存用户信息
    public AjaxResult saveLogininfor(LogInfo sysLogininfor);
}
