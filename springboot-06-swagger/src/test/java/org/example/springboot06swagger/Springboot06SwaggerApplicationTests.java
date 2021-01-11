package org.example.springboot06swagger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot06SwaggerApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    @Test
    void contextLoads() {
        // 简单邮件发送
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("通过SpringBoot发来的邮件");
        mailMessage.setText("你好，这只是一条测试，请你忽略");
        mailMessage.setFrom("xxx@163.com");
        mailMessage.setTo("xxx@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() {
        // 复杂邮件发送
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setSubject("通过SpringBoot发来的邮件");
            helper.setText("<h2 style='color:red'>你好，这只是一条测试，请你忽略</h2>", true);
            // 还可以加附件
            //System.out.println(new File(".").getAbsolutePath());
            helper.addAttachment("图片.jpg", new File("src/main/resources/1.jpg"));
            helper.setFrom("xxx@163.com");
            helper.setTo("xxx@qq.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
