package com.example.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 用于绑定exchange,queues
     */
    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 发送消息
     */
    @Test
    public void send() {
        Map<String, String> map = new HashMap<>();
        map.put("HELLO", "你好");
        map.put("Listener", "监听");
        //广播类型
        //对象被默认序列化以后发出去，所以说乱的，改用json序列化见rabbitConfig
        rabbitTemplate.convertAndSend("test.direct", "test.direct", map);
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("test.direct");
        System.out.println(o != null ? o.getClass() : null);
        System.out.println(o);
    }

    @Test
    public void createExchange() {
        amqpAdmin.declareExchange(new DirectExchange("createExchangeByJava"));
        //amqpAdmin.declareQueue(new Queue("createByJava"));
    }
}

