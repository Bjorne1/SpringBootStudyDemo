package com.example.dubboprovider;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 15:53
 */
@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String get() {
        return "Ticket";
    }
}
