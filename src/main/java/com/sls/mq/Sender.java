package com.sls.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者-生产消息
 * @author sls
 **/
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void directSend(String message) {
        System.out.println("Direct 发送消息：" + message);
        // 参数一：交换器名称，可以省略（省略存储到AMQP default交换器）
        // 参数2：路由键名称（direct模式下路由键=队列名称）；
        // 参数三：存储消息
        this.rabbitTemplate.convertAndSend("direct", message);
    }
}
