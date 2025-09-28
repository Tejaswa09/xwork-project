package com.xworkz.rpapp.service.impl;

import com.xworkz.rpapp.dto.LoginDto;
import com.xworkz.rpapp.dto.UserDto;
import com.xworkz.rpapp.entity.LoginEntity;
import com.xworkz.rpapp.entity.UserEntity;
import com.xworkz.rpapp.repo.RPRepo;
import com.xworkz.rpapp.service.RPService;
import com.xworkz.rpapp.utils.EmailSender;
import com.xworkz.rpapp.utils.Otp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Service
public class RPServiceImpl implements RPService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RPRepo repo;

    @Autowired
    EmailSender emailSender;

    @Autowired
    Otp otp;

    @Override
    public boolean signUp(UserDto dto) {
        UserEntity entity = new UserEntity();

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        BeanUtils.copyProperties(dto, entity, "dateOfBirth");
        entity.setDateOfBirth(StringToLastDate(dto.getDateOfBirth()));
        return repo.save(entity);
    }

    @Override
    public UserDto isEmailAvailble(String email) {
        try {
            UserDto dto = new UserDto();
            UserEntity entity = repo.entityByEmail(email);
            BeanUtils.copyProperties(entity, dto, "dateOfBirth");
            dto.setDateOfBirth(entity.getDateOfBirth().toString());

            return dto;
        } catch (NullPointerException e) {
            return new UserDto();
        }

    }

    @Override
    public UserDto isMobileNumberAvailable(Long mobileNumber) {
        try{
            UserDto dto = new UserDto();
            UserEntity entity = repo.entityByMobile(mobileNumber);
            BeanUtils.copyProperties(entity, dto, "dateOfBirth");
            dto.setDateOfBirth(entity.getDateOfBirth().toString());

            return dto;
        }catch (NullPointerException e){
            return new UserDto();
        }

    }

    @Override
    public String  loginValidation(String emailOrMobileNumber, String password) {
        String isEmailOrMobile = checkEmailOrMobile(emailOrMobileNumber);
        UserEntity entity;

        if(isEmailOrMobile.equals("Invalid Mobile")){
            return isEmailOrMobile;
        }else if (isEmailOrMobile.equals("Invalid email")){
            return isEmailOrMobile;
        }else{
            if(isEmailOrMobile.equals("mobile")){
               entity= repo.entityByMobile(Long.valueOf(emailOrMobileNumber));
               return validatePassword(entity,password,emailOrMobileNumber);
            }else {
                entity = repo.entityByEmail(emailOrMobileNumber);
                return validatePassword(entity,password,emailOrMobileNumber);
            }
        }

    }

    @Override
    public boolean genarateAndSendOtp(String email) {
        try{
            String generatedOtp=otp.otpGenerator();
            String mailBody ="Otp for reset password is "+generatedOtp;

            emailSender.simpleMessage(email,"forgot password",mailBody);
            repo.updateOtp(email,passwordEncoder.encode(generatedOtp));
            return true;
        }catch(MailException e){
            System.err.println(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean vaidateOtp(String otp, String email) {
        UserEntity entity = repo.entityByEmail(email);

        if (passwordEncoder.matches(otp,entity.getOtp())){
            return true;
        }
        return false;
    }

    //validation of the password
    private String  validatePassword(UserEntity entity,String password,String emailOrMobileNumber) {
        try{
            if(passwordEncoder.matches(password,entity.getPassword())) {
                LoginEntity loginEntity = new LoginEntity();
                LoginDto loginDto = new LoginDto();
                loginDto.setSlNo(0);
                loginDto.setEmailOrMobileNumber(emailOrMobileNumber);
                loginDto.setPassword(entity.getPassword());
                loginDto.setTime(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
                loginDto.setDate(LocalDate.now().toString());
                BeanUtils.copyProperties(loginDto,loginEntity);

                repo.loginInfoSave(loginEntity);
                return "login Successful";
            }else{
                return "login UnSuccessful";
            }
        }catch(NullPointerException e){
            return "Username not found";
        }
    }
//check username is mobile or email
    private String checkEmailOrMobile(String emailOrMobileNumber) {
        if(emailOrMobileNumber.matches("\\d+")){
            if(emailOrMobileNumber.matches("^[6-9]\\d{9}$")){
                return "mobile";
            }else {
                return "Invalid Mobile";
            }
        }else{
            if(emailOrMobileNumber.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
                return "email";
            }else {
                return "Invalid email";
            }
        }
    }



    private LocalDate StringToLastDate(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateOfBirth, formatter);
    }
}