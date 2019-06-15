package com.sls.mq_one.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sls
 **/
@Component
@RabbitListener(queues = "log.all")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("log.*消费消息：" + message);
    }
}
