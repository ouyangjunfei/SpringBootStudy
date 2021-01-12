package org.example.dubboprovider;

import org.example.dubbo.same.api.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DubboProviderApplicationTests {

    @Autowired
    private TicketService ticketService;

    @Test
    void contextLoads() {
        System.out.println(ticketService.getTicket());
    }

}
