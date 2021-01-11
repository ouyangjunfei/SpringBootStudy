package org.example.springboot06swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.springboot06swagger.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "AsyncController", tags = "异步测试")
@RestController
public class AsyncController {

    private AsyncService asyncService;

    @Autowired
    public void setAsyncService(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @ApiOperation("模拟发送邮件")
    @GetMapping("/async/mail/send")
    public String sendMail() {
        asyncService.sendMail();
        return "邮件已经发送";
    }
}
