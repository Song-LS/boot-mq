package com.sls.mq_two;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author sls
 **/
@Component
@Slf4j
public class ConfirmConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "confirm.message",durable = "true")
            ,exchange = @Exchange(value = "exchange-2",type = "topic")
            ,key = "confirm.message"))
    public void receive(String message, Message message1, Channel channel) throws IOException {
        log.info("消费者收到消息：{}", message);
        long deliveryTag = message1.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag, false);
    }

}
