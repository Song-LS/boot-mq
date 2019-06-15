package com.sls.mq_one.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *@author sls
 **/
@Configuration
public class DirectConfig {

    final static String QUEUE_NAME = "direct";
    final static String EXCHANGE_NAME = "mydirect";

    @Bean
    public Queue queueDirect() {
        // 声明队列， 参数1：队列名称， 参数2：是否持久化
        return new Queue(DirectConfig.QUEUE_NAME, false);
    }

    //  设置默认的交换机，以下部门都可以不配置，不设置使用默认交换器（AMQP default)
    @Bean
    DirectExchange directExchange() {
        // 参数1： 交换器名称， 参数2：是否持久化， 参数3：是否自动删除消息
        return new DirectExchange(DirectConfig.EXCHANGE_NAME, false,false);
    }

    // 绑定“direct” 队列到上面配置的“mydirect”路由器
    @Bean
    Binding bindingExchangeDirectQueue(Queue queueDirect, DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirect).to(directExchange).with(DirectConfig.QUEUE_NAME);
    }
}
