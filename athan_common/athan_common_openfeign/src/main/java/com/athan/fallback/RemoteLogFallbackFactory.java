package com.athan.fallback;

import com.athan.RemoteLogService;

import com.athan.user.model.LogInfo;
import com.athan.util.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 16:30
 */
@Slf4j
@Component
public class RemoteLogFallbackFactory implements RemoteLogService {
    @Override
    public AjaxResult saveLogininfor(LogInfo sysLogininfor) {
        log.info("获取用户信息服务调用失败");
        return null;
    }

    @Override
    public AjaxResult selectByUserName(String username) {
        log.info("获取用户信息服务调用失败");
        return null;
    }
}
