package com.sls.mq_one.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sls
 **/
@Component
@RabbitListener(queues = "log.all.error")
public class TopicReceiver3 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("log.*.error消费消息：" + message);
    }
}
