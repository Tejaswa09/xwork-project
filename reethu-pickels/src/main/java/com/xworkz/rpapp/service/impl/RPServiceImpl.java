package com.xworkz.rpapp.service.impl;

import com.xworkz.rpapp.dto.UserDto;
import com.xworkz.rpapp.entity.UserEntity;
import com.xworkz.rpapp.repo.RPRepo;
import com.xworkz.rpapp.service.RPService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Service
public class RPServiceImpl implements RPService {
    @Autowired
    RPRepo repo;

    @Override
    public boolean signUp(UserDto dto) {
        UserEntity entity = new UserEntity();

        BeanUtils.copyProperties(dto,entity,"dateOfBirth");

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatedDate= LocalDate.parse(dto.getDateOfBirth(),format);
        entity.setDateOfBirth(formatedDate);
        System.out.println(entity);
        return repo.save(entity);
    }

    @Override
    public UserDto isEmailAvailble(String email) {
        UserDto dto = new UserDto();

        BeanUtils.copyProperties(repo.isEmailAvailable(email),dto);

        return dto;
    }

    @Override
    public UserDto isMobileNumberAvailable(Long mobileNumber) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(repo.isMobileNumberAvailable(mobileNumber),dto);
        return dto;
    }
}