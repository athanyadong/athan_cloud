package com.athan.rabbit;

import com.alibaba.fastjson.JSON;
import com.athan.model.rabbit.RabbitMQConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 10:39
 */
@Slf4j
@Component
public class DeadReceiver {
    @RabbitHandler
    @RabbitListener(queues = RabbitMQConstant.ATHAN_DEAD_LETTER_QUEUE)
    public void process( Channel channel, Message mqMsg) throws IOException {
        String msgText = new String(mqMsg.getBody(), StandardCharsets.UTF_8);
        log.info("rabbitMQ接收处理死信队列的信息为:{}", JSON.toJSONString(msgText));

        channel.basicAck(mqMsg.getMessageProperties().getDeliveryTag(),false);
    }
}
