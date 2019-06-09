package com.sls.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sls
 **/
@Component
@RabbitListener(queues = "fanout2")
public class FanoutReceiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Fanout2(FanoutReceiver2)消费消息" + message);
    }
}
