package com.athan.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @aurhor yyh
 * @description rabbit mq 配置信息 用户名密码
 * @date 2022/7/12 9:45
 */
@Data
@Component
@Slf4j
public class RabbitMQConfig {

    //配置rabbitmq的基本信息
    @Value("${spring.rabbitmq.addresses}")
    private String address;//地址
    @Value("${spring.rabbitmq.username}")
    private String username;//用户名
    @Value("${spring.rabbitmq.password}")
    private String password;//密码
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;//虚拟主机

//    private Boolean publisherConfirms;//手动控制  发送确认

    @Value("${spring.rabbitmq.publisher-returns}")
    private Boolean publisherReturns; // 手动控制  发送返回
    /**
     * 好处 是不丢失任务，只有消费者发送ack反馈之后才会从rabbit中删除掉
     * <p>
     * 缺点 RabbitMQ的ACK的消息确认机制   如果消费者发生异常，ack没法送消息应答。，Message会一直重新分发。会发生内存泄漏
     * <p>
     * 解决方法 ：
     * （1）在程序处理中可以进行异常捕获，保证消费者的程序正常执行。
     * <p>
     * （2）使用RabbitMQ的ack的配置确认机制。（开启重试次数）
     * <p>
     * （3）手动设置消息应答。如果消费端异常，也返回应答成功，再把未消费成功的数据记录下来，进行补偿。
     */
    @Value("${spring.rabbitmq.listener.direct.acknowledge-mode}")
    private String directAcknowledgeMode; //开启ack  直接确认
    @Value("${spring.rabbitmq.listener.simple.acknowledge-mode}")
    private String simpleAcknowledgeMode; //开启ack   简单确认  manual
    @Value("${spring.rabbitmq.connection-timeout}")
    private Integer connectionTimeout;//连接超时时间
    @Value("${spring.rabbitmq.cache.channel.checkout-timeout}")
    private Integer checkoutTimeout;//通道超时时间
    @Value("${spring.rabbitmq.cache.channel.size}")
    private Integer channelSize; // 设置通道数目的限制
    @Value("${spring.rabbitmq.cache.connection.size}")
    private Integer connectionCacheSize; //设置缓存connection数量 缓存通道的矢量

    private Boolean templateMandatory;//与return机制结合配置次属性

    /**
     * NONE值是禁用发布确认模式，是默认值
     * CORRELATED值是发布消息成功到交换器后会触发回调方法，如1示例
     * SIMPLE值经测试有两种效果，其一效果和CORRELATED值一样会触发回调方法，
     * 其二在发布消息成功后使用rabbitTemplate调用waitForConfirms或waitForConfirmsOrDie方法等待broker节点返回发送结果，
     * 根据返回结果来判定下一步的逻辑，要注意的点是waitForConfirmsOrDie方法如果返回false则会关闭channel，则接下来无法发送消息到broker;
     */
    @Value("${spring.rabbitmq.publisher-confirm-type}")
    private String publisherConfirmType;

    /**
     * Spring启动容器时执行
     */
    @PostConstruct
    private void initialize() {
        log.info("[rabbitmq] address: {}, username: {}, password: {}, virtualHost: {}, publisherConfirmType: {}, publisherReturns, " +
                        "templateMandatory: {}, directAcknowledgeMode: {}, simpleAcknowledgeMode: {}, connectionTimeout: {}, " +
                        "checkoutTimeout: {}, channelSize: {}, connectionCacheSize：{}",
                address, username, password, virtualHost, publisherConfirmType, publisherReturns,
                templateMandatory, directAcknowledgeMode, simpleAcknowledgeMode, connectionTimeout,
                checkoutTimeout, connectionCacheSize);
    }

    @Override
    public String toString() {
        return String.format("[rabbitmq] addresse: %s, username: %s, password: %s, virtualHost: %s, publisherConfirmType: %s, publisherReturns: %s, " +
                        "templateMandatory: %s, directAcknowledgeMode: %s, simpleAcknowledgeMode: %s, connectionTimeout: %s, " +
                        "checkoutTimeout: %s, channelSize: %s, connectionCacheSize：%s",
                address, username, password, virtualHost, publisherConfirmType, publisherReturns,
                templateMandatory, directAcknowledgeMode, simpleAcknowledgeMode, connectionTimeout,
                checkoutTimeout, channelSize, connectionCacheSize);
    }


}




