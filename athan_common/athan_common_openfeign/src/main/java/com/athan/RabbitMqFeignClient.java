package com.athan;


import com.athan.fallback.RabbitMwFeignClintBack;
import com.athan.model.rabbit.MqDTO;
import com.athan.model.rabbit.RabbitMQConstant;
import com.athan.model.rabbit.ServiceConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Service
@FeignClient(name = ServiceConstant.ATHAN_MQ_DEMO,url = "http://127.0.0.1:10215/mq",path = "/mq",fallback = RabbitMwFeignClintBack.class)
public interface RabbitMqFeignClient {


    /**
     * @param exchange:   交换机
     * @param routingKey: 路由键
     * @param message:    消息内容
     */
    @PostMapping("/send/{exchange}/{routingKey}")
    void sendMsg(@PathVariable("exchange") String exchange, @PathVariable("routingKey") String routingKey, MqDTO message);

}
