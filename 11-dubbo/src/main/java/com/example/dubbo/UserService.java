package com.example.dubbo;


import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 15:45
 */
@Service
public class UserService {

    /**
     * TicketService就是由dubbo-provider发布的服务
     */
    @Reference
    TicketService ticketService;

    public void get() {
        ticketService.get();
    }
}
