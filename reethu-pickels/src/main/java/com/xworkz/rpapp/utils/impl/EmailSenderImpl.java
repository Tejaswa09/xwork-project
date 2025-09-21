package com.xworkz.rpapp.utils.impl;

import com.xworkz.rpapp.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl implements EmailSender  {
    @Autowired
    private JavaMailSender javaMailSender;

    public void simpleMessage(String to, String subject, String message){

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom("reethupickels@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("OTP");
            mailMessage.setText(message);

            javaMailSender.send(mailMessage);

    }


}
