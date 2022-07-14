package com.athan.service.impl;

import com.athan.mapper.LogInfoMapper;

import com.athan.service.LogInfoService;
import com.athan.user.model.LogInfo;
import com.athan.util.web.AjaxResult;

import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 16:44
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Resource
    private LogInfoMapper logInfoMapper;

    //保存用户登录信息
    public AjaxResult saveLogininfor( LogInfo sysLogininfor){
        //  保存日志信息
        int i = logInfoMapper.insertLogininfor(sysLogininfor);
        if (i>0){
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");
    }


}
