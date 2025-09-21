package com.xworkz.rpapp.utils;

public interface EmailSender {
    void simpleMessage(String to, String subject, String message);
}
