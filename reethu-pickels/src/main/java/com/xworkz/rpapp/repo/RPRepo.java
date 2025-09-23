package com.xworkz.rpapp.repo;

import com.xworkz.rpapp.dto.LoginDto;
import com.xworkz.rpapp.entity.LoginEntity;
import com.xworkz.rpapp.entity.UserEntity;

public interface RPRepo {
    boolean save(UserEntity entity);

    UserEntity entityByEmail(String email);

    UserEntity entityByMobile(Long mobileNumber);

    void loginInfoSave(LoginEntity loginDto);

    void updateOtp(String email,String generatedOtp);
}
