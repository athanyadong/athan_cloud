package com.athan.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @aurhor yyh
 * @description 配置连接工厂
 * @date 2022/7/12 10:02
 */
@Configuration
public class RabbitConnectionFactoryConfig {


    @Autowired
    private RabbitMQConfig rabbitMQConfig; //基本配置信息


    //配置工厂
    @Bean
    public ConnectionFactory connectionFactory(){
        return getConnectionFactory(rabbitMQConfig);
    }


    /**
     * @Description: RabbitTemplate使用CachingConnectionFactory作为连接工厂
     * 注意：在一个应用里面同时存在消费者和生产者时，建议使用一个具有相同选项的单独CachingConnectionFactory实例，
     * 一个用于生产者，一个用于消费者。这是为了避免消费者由于生产者阻塞而阻塞
     */
    private CachingConnectionFactory getConnectionFactory(RabbitMQConfig simpleRabbitMqConfig) {
        CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses(simpleRabbitMqConfig.getAddress()); //设置集群地址
        cachingConnectionFactory.setUsername(simpleRabbitMqConfig.getUsername()); //名称
        cachingConnectionFactory.setPassword(simpleRabbitMqConfig.getPassword()); //密码
        //设置虚拟主机
        cachingConnectionFactory.setVirtualHost(simpleRabbitMqConfig.getVirtualHost());
        // 如果要进行消息回调，则这里必须要设置为true
        cachingConnectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        // 开启发送失败退回
        cachingConnectionFactory.setPublisherReturns(simpleRabbitMqConfig.getPublisherReturns());
        // 设置连接超时时间
        cachingConnectionFactory.setConnectionTimeout(simpleRabbitMqConfig.getConnectionTimeout());

        //创建一个线程工程指定名称为rabbitmq-pool-0
        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("rabbitmq-pool-%d").build();
        /**
         * 参数：
         * corePoolSize - 保留在池中的线​​程数，即使它们是空闲的，除非设置allowCoreThreadTimeOut
         * maximumPoolSize – 池中允许的最大线程数
         * keepAliveTime – 当线程数大于核心时，这是多余的空闲线程在终止前等待新任务的最长时间。
         * unit – keepAliveTime参数的时间单位
         * workQueue – 用于在执行任务之前保存任务的队列。此队列将仅保存由execute方法提交的Runnable任务。
         * threadFactory – 执行器创建新线程时使用的工厂
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.SECONDS, new SynchronousQueue<>(), build);
        cachingConnectionFactory.setExecutor(threadPoolExecutor);
        //设置RabbitMQ缓存模式，共有两个缓存模式如下：
        //1、CONNECTION模式，这个模式下允许创建多个Connection(链接)，会缓存一定数量的Connection，每个Connection中同样会缓存一些Channel，(通道)
        // 除了可以有多个Connection，其它都跟CHANNEL模式一样。
        //2、CHANNEL模式，程序运行期间ConnectionFactory会维护着一个Connection，
        // 所有的操作都会使用这个Connection，但一个Connection中可以有多个Channel，
        // 操作rabbitmq之前都必须先获取到一个Channel，
        // 否则就会阻塞（可以通过setChannelCheckoutTimeout()设置等待时间），
        // 这些Channel会被缓存（缓存的数量可以通过setChannelCacheSize()设置）；
        // connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);

        //设置每个Connection中缓存Channel的数量，不是最大的。操作rabbitmq之前（send/receive message等）
        // 要先获取到一个Channel.获取Channel时会先从缓存中找闲置的Channel，如果没有则创建新的Channel，
        // 当Channel数量大于缓存数量时，多出来没法放进缓存的会被关闭。
        cachingConnectionFactory.setChannelCacheSize(simpleRabbitMqConfig.getChannelSize());

        //单位：毫秒；
        //从缓存获取不到可用的Channel时，不会创建新的Channel，会等待这个值设置的毫秒数
        //同时，在CONNECTION模式，这个值也会影响获取Connection的等待时间，
        //超时获取不到Connection也会抛出AmqpTimeoutException异常。
        cachingConnectionFactory.setChannelCheckoutTimeout(simpleRabbitMqConfig.getCheckoutTimeout());

        //setConnectionLimit：仅在CONNECTION模式使用，设置Connection的数量上限。
        cachingConnectionFactory.setConnectionLimit(100);
        //仅在CONNECTION模式使用，设置Connection的缓存数量。
        // connectionFactory.setConnectionCacheSize(simpleRabbitMqConfig.getConnectionCacheSize());

        return cachingConnectionFactory;
    }


}
