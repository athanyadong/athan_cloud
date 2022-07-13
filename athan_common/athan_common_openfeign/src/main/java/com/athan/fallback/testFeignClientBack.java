package com.athan.fallback;

import com.athan.testFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/12 15:58
 */
@Component
@Slf4j
public class testFeignClientBack implements testFeignClient {

    @Override
    public String test() {
        log.error("远程调用失败");
        return null;
    }
}
