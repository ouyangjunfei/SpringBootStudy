package org.example.dubboprovider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.dubbo.same.api.TicketService;
import org.springframework.stereotype.Service;

// 在项目一启动就可以被扫描到并注册到注册中心
@DubboService
@Service
public class TickServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "<欧阳>";
    }
}
