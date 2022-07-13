package com.athan.fallback;

import com.alibaba.fastjson.JSON;
import com.athan.SysUserService;
import com.athan.doman.R;
import com.athan.util.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 17:26
 */
@Component
@Slf4j
public class SysUserServiceBack implements SysUserService {
    @Override
    public R selectUserByUserName(String username) {
        log.info("获取用户信息调用失败，获取到的参数为:{}", JSON.toJSONString(username));
        return null;
    }
}
