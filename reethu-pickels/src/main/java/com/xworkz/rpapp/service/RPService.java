package com.xworkz.rpapp.service;

import com.xworkz.rpapp.dto.UserDto;

public interface RPService {
    boolean signUp(UserDto dto);

    UserDto isEmailAvailble(String email);

    UserDto isMobileNumberAvailable(Long mobileNumber);
}
