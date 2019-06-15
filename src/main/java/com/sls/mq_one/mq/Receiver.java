package com.sls.mq_one.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *消息接收者-消费消息
 *@author sls
 **/
@Component
@RabbitListener(queues = "direct")
public class Receiver {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 监听消费消息
     * @param message
     */
    @RabbitHandler
    public void process(String message) {
        System.out.println("Direct 消费消息：" + message);
    }
}
