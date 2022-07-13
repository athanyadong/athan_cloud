package com.athan.service.impl;

import com.athan.mapper.LogInfoMapper;
import com.athan.model.LogInfo;
import com.athan.service.LogInfoService;
import com.athan.util.web.AjaxResult;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    //保存信息
    public AjaxResult saveLogininfor( LogInfo sysLogininfor){
        //  保存日志信息
        int i = logInfoMapper.insertLogininfor(sysLogininfor);
        if (i>0){
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");

    }
}
