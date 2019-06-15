package com.sls.mq_one.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sls
 **/
@Component
public class TopicSender {

    @Autowired
    private final AmqpTemplate amqpTemplate;

    public TopicSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void topicSender(String message) {
        // 路由键
        String routingKey = "log.all.error";
        System.out.println(routingKey + "发送消息：" + message);
        this.amqpTemplate.convertAndSend("topicExchange", routingKey, message);
    }
}
