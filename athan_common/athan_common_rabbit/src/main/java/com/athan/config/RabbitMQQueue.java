package com.athan.config;

import com.athan.model.rabbit.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @aurhor yyh
 * @description 配置队列信息
 * @date 2022/7/12 10:12
 */
@Configuration
public class RabbitMQQueue {

    //定义普通消息队列
    @Bean("chat")
    public Queue chat(){
        Map<String, Object> args = new HashMap<>(2);
        //x-dead-letter-exchange 这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitMQConstant.ATHAN_DEAD_LETTER_EXCHANGE);
        //x-dead-letter-routing-key 这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", RabbitMQConstant.ATHAN_DEAD_LETTER_ROUTING_KEY);
        //x-message-ttl 设置过期时间（1s=1000）
        args.put("x-message-ttl",3000);
        return new Queue(RabbitMQConstant.ATHAN_CHAT_MESSAGE_QUEUE, true, false, false, args);
    }


    //定义普通的交换机，进行绑定
    @Bean("chatExchange")
    public DirectExchange  chatExchange(){
      return   new DirectExchange (RabbitMQConstant.ATHAN_CHAT_MESSAGE_EXCHANGE);
    }


    //定义死信队列
    @Bean("deadChat")
    public Queue deadChat(){
        return new Queue(RabbitMQConstant.ATHAN_DEAD_LETTER_QUEUE,true);
    }

    //定义死信交换机
    @Bean("deadChatExchange")
    public DirectExchange  deadChatExchange(){
        return new DirectExchange (RabbitMQConstant.ATHAN_DEAD_LETTER_EXCHANGE);
    }


    //定义延迟交换机和队列
    @Bean("delayChat")
    public Queue delayChat(){
        HashMap<String, Object> hashMap = new HashMap<>(2);
        //这里声明当前队列绑定的死信交换机
        hashMap.put("x-dead-letter-exchange",RabbitMQConstant.ATHAN_DEAD_LETTER_EXCHANGE);
        //这里声明当前队列的死信路由key
        hashMap.put("x-dead-letter-routing-key", RabbitMQConstant.ATHAN_DEAD_LETTER_ROUTING_KEY);
        // x-message-ttl  声明队列的TTL
        hashMap.put("x-message-ttl",6000);
        return QueueBuilder.durable(RabbitMQConstant.ATHAN_DELAY_LETTER_QUEUE).withArguments(hashMap).build();

    }
    /**
     * 延迟交换机
     * @return
     */
    @Bean("delayedExchange")
    public DirectExchange delayedExchange(){
        return new DirectExchange(RabbitMQConstant.ATHAN_DELAY_LETTER_EXCHANGE);
    }

    /**
     * 延迟队列绑定
     * @return
     */
    @Bean
    public Binding delayedBinding(@Qualifier("delayChat") Queue queue,@Qualifier("delayedExchange") DirectExchange  directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(RabbitMQConstant.ATHAN_DELAY_LETTER_ROUTING_KEY);
    }




    @Bean  //声明普通消息队列，绑定到普通的交换机，
    public Binding bindingChatExchange(@Qualifier("chat") Queue queue,@Qualifier("chatExchange") DirectExchange  directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(RabbitMQConstant.ATHAN_CHAT_MESSAGE_ROUTING_KEY);
    }

    /**
     * 绑定交换机（死信）
     * @return
     */
    @Bean
    public Binding bindingDeadExchange(@Qualifier("deadChat") Queue queue,@Qualifier("deadChatExchange") DirectExchange  directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(RabbitMQConstant.ATHAN_DEAD_LETTER_ROUTING_KEY);
    }

}
