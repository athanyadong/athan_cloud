package com.athan.model.rabbit;

/**
 * @aurhor yyh
 * @description rabbit的常亮信息
 * @date 2022/7/12 9:54
 */
public interface RabbitMQConstant {
    /**
     * 消息队列
     */
    public static String ATHAN_CHAT_MESSAGE_QUEUE = "athan.chat.message.queue";
    /**
     * 消息交换机
     */
    public static String ATHAN_CHAT_MESSAGE_EXCHANGE="athan.chat.message.queue.exchange";

    /**
     * 消息路由key
     */
    public static String ATHAN_CHAT_MESSAGE_ROUTING_KEY="athan.chat.message.routing.key";




    //------------------------------------------------------------------------------------------

    /**
     * 死信队列
     */
    public static String ATHAN_DEAD_LETTER_QUEUE="athan_dead_letter_queue";


    /**
     * 死信交换机
     */
    public static String ATHAN_DEAD_LETTER_EXCHANGE="athan_dead_letter_exchange";

    /**
     * 死信路由key
     */
    public static String ATHAN_DEAD_LETTER_ROUTING_KEY="athan_dead_letter_routing_key";



    //-------------------------------------------------------------------------------------------

    //延迟队列
    String ATHAN_DELAY_LETTER_QUEUE="athan.delay.letter.queue";
    //延迟交换机
    String ATHAN_DELAY_LETTER_EXCHANGE="athan.delay.letter.exchange";
    //延迟路由key
     String ATHAN_DELAY_LETTER_ROUTING_KEY="athan_delay_letter_routing_key";







    Integer DEAD_TIME_OUT=3;
}
