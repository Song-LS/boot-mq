package com.sls.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sls
 **/
@Component
@RabbitListener(queues = "fanout")
public class FanoutReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Fanout(FanoutReceiver)消费消息" + message);
    }
}
