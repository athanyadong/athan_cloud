package com.athan.controller;

import com.alibaba.fastjson.JSON;
import com.athan.model.rabbit.MqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

/**
 * @aurhor yyh
 * @description rabbit实现
 * @date 2022/7/12 10:32
 */
@Slf4j
@Configuration
@RequestMapping("mq")
@RestController
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ConnectionFactory connectionFactory;  //使用的配置好的连接工厂


    /**
     * @param exchange:   交换机
     * @param routingKey: 路由键
     * @param dto:    消息内容
     * @Description: RabbitMQ发送消息(指定交换机)
     */
    @PostMapping("/send/{exchange}/{routingKey}")
    public void sendMsg(@PathVariable("exchange") String exchange, @PathVariable("routingKey") String routingKey, @RequestBody MqDTO dto) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, dto.getData());
        } catch (AmqpException e) {
            e.printStackTrace();
            log.info("获取到的错误信息为:{}", JSON.toJSONString(e.getLocalizedMessage()));
        }
    }

}
