package com.athan.fallback;

import com.athan.RabbitMqFeignClient;
import com.athan.model.rabbit.MqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @aurhor yyh
 * @description \
 * @date 2022/7/12 14:05
 */
@Component
@Slf4j
public class RabbitMwFeignClintBack implements RabbitMqFeignClient {
    @Override
    public void sendMsg(String exchange, String routingKey, MqDTO message) {
        log.error("调用sendMsg({}, {}, {})执行Fallback", exchange, routingKey, message);

    }
}
