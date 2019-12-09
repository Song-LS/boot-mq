package com.sls.mq_one.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sls
 **/
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        System.out.println("发送消息：" + message);
        this.amqpTemplate.convertAndSend("myfanout", "fanout", message);
    }

    public void send2(String message) {
        System.out.println("发送消息2：" + message);
        this.amqpTemplate.convertAndSend("myfanout", "fanout2", message);
    }
}
