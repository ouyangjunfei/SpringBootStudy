package org.example.dubboconsumer.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.dubbo.same.api.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //想拿到提供者的票据，要去注册中心拿服务

    // 由于已经在application.yml中设置了地址，所以此处无需设置
    @DubboReference
    private TicketService ticketService;

    public String buyTicket() {
        return ticketService.getTicket();
    }
}
