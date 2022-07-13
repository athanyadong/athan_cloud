package com.athan.controller;

import com.alibaba.fastjson.JSON;
import com.athan.RabbitMqFeignClient;
import com.athan.model.rabbit.MqDTO;
import com.athan.model.rabbit.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/12 14:33
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    RabbitMqFeignClient rabbitMqFeignClient;

    @GetMapping("athan")
    public String test(){

        return "Athan";
    }

    @PostMapping("send2")
    public String sendMessage(){
        MqDTO mqDTO = new MqDTO();
        mqDTO.setData("小韩在此");
        try {
            rabbitMqFeignClient.sendMsg(RabbitMQConstant.ATHAN_DELAY_LETTER_EXCHANGE,RabbitMQConstant.ATHAN_DELAY_LETTER_ROUTING_KEY,mqDTO);
            log.info("发送了信息");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("错误信息为:{}", JSON.toJSONString(e.getMessage()));
        }
        return "发送";
    }


}
