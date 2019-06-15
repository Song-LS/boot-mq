package com.sls.mq_two;

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
public class ConfirmConfiguration {

    /**
     * 声明 confirm.message 队列
     * @return
     */
    @Bean
    public Queue confirmQueue() {
        return new Queue("confirm.message");
    }

    /**
     * 声明一个名为exchange-2 的交换机
     */
    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange("exchange-2");
    }

    /**
     * 将confirm.message 的队列绑定到exchange-2 交换机
     */
    @Bean
    public Binding bindingMessage() {
        return BindingBuilder.bind(confirmQueue()).to(exchange2()).with("confirm.message");
    }

}
