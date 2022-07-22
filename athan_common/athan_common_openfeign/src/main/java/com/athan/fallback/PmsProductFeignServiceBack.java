package com.athan.fallback;

import com.alibaba.fastjson.JSON;
import com.athan.PmsProductFeignService;
import com.athan.util.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/22 18:15
 */
@Component
@Slf4j
public class PmsProductFeignServiceBack implements PmsProductFeignService {
    @Override
    public AjaxResult getProduct(String id) {
        log.info("获取用户信息调用失败，获取到的参数为:{}", JSON.toJSONString(id));

        return null;
    }
}
