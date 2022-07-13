package com.athan;

import com.athan.fallback.RemoteLogFallbackFactory;
import com.athan.model.LogInfo;
import com.athan.model.rabbit.ServiceConstant;
import com.athan.util.web.AjaxResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import sun.security.util.SecurityConstants;


/**
 * 日志服务
 * 
 * @author ruoyi
 */
@Service
@FeignClient(value = ServiceConstant.ATHAN_SHOP_ADMIN, path = "/login" ,fallbackFactory = RemoteLogFallbackFactory.class,contextId = "admin3")
public interface RemoteLogService
{
    /**
     * 保存系统日志
     *
     * @param sysOperLog 日志实体
     * @param source 请求来源
     * @return 结果
     */
//    @PostMapping("/operlog")
//    public AjaxResult saveLog(@RequestBody SysOperLog sysOperLog, String source);

    /**
     * 保存访问记录
     *
     * @param sysLogininfor 访问实体
     * @param
     * @return 结果
     */
    @PostMapping("/logininfor")
    public AjaxResult saveLogininfor(@RequestBody LogInfo sysLogininfor);
}
