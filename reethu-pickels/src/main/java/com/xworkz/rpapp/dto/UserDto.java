package com.xworkz.rpapp.dto;

import com.xworkz.rpapp.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;

    @NotBlank(message = "First Name Should not be empty")
    private String firstName;

    @NotBlank(message = "Last Name should not be empty")
    private String lastName;

    @Email
    @NotBlank(message = "Email should not be Blank")
    private String email;

    @NotNull(message = "Mobile number should not be Blank")
    private Long mobileNumber;

    @NotBlank(message = "DateOfBirth should not be Blank")
    private String dateOfBirth;

    private Gender gender;

    @NotBlank(message = "Country Should not be Blank")
    private String country;

    @NotBlank(message = "State should not be blank")
    private String state;

    @NotBlank(message = "City Should not be blank")
    private String city;

    @NotNull(message = "Pincode should not be Blank")
    private Integer pincode;

    @NotBlank(message = "Password should not be blank")
    private String password;

    private String otp;
}
