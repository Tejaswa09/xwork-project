package com.xworkz.rpapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    int slNo;
    String emailOrMobileNumber;
    String password;
    String date;
    String time;
    String userNameType;
}
