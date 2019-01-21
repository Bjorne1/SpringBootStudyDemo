package com.example.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: wenchangsheng
 * @date: created in 2019/1/21
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(String name) {
        String ticket = restTemplate.getForObject("http://SPRINGCLOUD-EUREKA-PROVIDER/ticket", String.class);
        return name + "买了" + ticket;
    }
}
