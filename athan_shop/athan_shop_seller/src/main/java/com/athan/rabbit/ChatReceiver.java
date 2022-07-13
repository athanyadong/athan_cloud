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
 * @description 普通信息接受类
 * @date 2022/7/12 16:42
 */
@Component
@Slf4j
public class ChatReceiver {

    /**
     * 聊天消息
     */
    @RabbitHandler
    @RabbitListener(queues =RabbitMQConstant.ATHAN_CHAT_MESSAGE_QUEUE )
    public void chatMessage(Channel channel, Message message) throws IOException {

            String msgText = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("普通队列---》获取到的信息为:{}",JSON.toJSONString(msgText));
        log.info("普通队列--->转为死信获取到的信息为:{}",JSON.toJSONString(msgText));
            if (msgText.startsWith("12")){
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }
}
