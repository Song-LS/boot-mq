package com.sls.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sls
 **/
@Configuration
public class TopicConfig {

    // 队列名称
    final static String QUEUE_NAME = "log";
    final static String QUEUE_NAME2 = "log.all";
    final static String QUEUE_NAME3 = "log.all.error";
    // 交换器名称
    final static String EXCAHNGE_NAME = "topicExchange";

    @Bean
    public Queue queueTopic() {
        return new Queue(TopicConfig.QUEUE_NAME);
    }

    @Bean
    public Queue queueTopic2() {
        return new Queue(TopicConfig.QUEUE_NAME2);
    }

    @Bean
    public Queue queueTopic3() {
        return new Queue(TopicConfig.QUEUE_NAME3);
    }

    // 配置交换器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TopicConfig.EXCAHNGE_NAME);
    }

    // 在Topic Exchange中“#”可以匹配所有内容，而“*”则是匹配一个字符段的内容。
    // 绑定队列到交换器，并设置路由键（log.#）
    @Bean
    Binding bindingTopicExchangeQueue(Queue queueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopic).to(topicExchange).with("log.#");
    }

    // 绑定队列到交换器，并设置路由键（log.*）
    @Bean
    Binding bindingTopicExchangeQueue2(Queue queueTopic2, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopic2).to(topicExchange).with("log.*");
    }

    // 绑定队列到交换器，并设置路由键（log.*.error）
    @Bean
    Binding bindingTopicExchangeQueue3(Queue queueTopic3, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopic3).to(topicExchange).with("log.*.error");
    }

}
