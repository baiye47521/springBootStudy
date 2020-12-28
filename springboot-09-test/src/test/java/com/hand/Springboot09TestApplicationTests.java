package com.hand;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        //一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("小帅哥～");
        message.setText("你为什么这么帅！");
        message.setTo("baiye47521@163.com");
        message.setFrom("1421485266@qq.com");
        mailSender.send(message);

    }

    @Test
    void contextLoads2() throws MessagingException {

        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //正文
        helper.setSubject("你太帅了～～～～～～～");
        helper.setText("<p style='color:red'>为什么你这么帅，帅的过分！</p>",true);

        //附件
        helper.addAttachment("h.jpg",new File("/Users/ludongoeng/Downloads/test.jpg"));

        helper.setTo("baiye47521@163.com");
        helper.setFrom("1421485266@qq.com");

        mailSender.send(mimeMessage);
    }

    /**
    * @Description:
    * @Param: html
    * @Param: subject
    * @return:
    * @Author: ludongpeng
    * @Date: 2020/12/17
    */
    public void sendMail(Boolean html,String subject, String text) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);

        //正文
        helper.setSubject(subject);
        helper.setText(text,true);

        //附件
        helper.addAttachment("h.jpg",new File("/Users/ludongoeng/Downloads/test.jpg"));

        helper.setTo("baiye47521@163.com");
        helper.setFrom("1421485266@qq.com");

        mailSender.send(mimeMessage);
    }


}
