package com.xworkz.rpapp.repo;

import com.xworkz.rpapp.entity.UserEntity;

public interface RPRepo {
    boolean save(UserEntity entity);

    UserEntity isEmailAvailable(String email);

    UserEntity isMobileNumberAvailable(Long mobileNumber);
}
