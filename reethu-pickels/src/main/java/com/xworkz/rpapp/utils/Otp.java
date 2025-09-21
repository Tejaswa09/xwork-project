package com.xworkz.rpapp.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Otp {
    public String otpGenerator(){
        Random random = new Random();

       int generatedOtp = random.nextInt(999999);

        System.out.println(generatedOtp);
        return String.valueOf(generatedOtp);
    }
}
