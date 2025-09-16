package com.xworkz.rpapp.controller;

import com.xworkz.rpapp.dto.UserDto;
import com.xworkz.rpapp.service.RPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class ReethuPickelsController {
    @Autowired
    RPService service;

    @GetMapping("registerPage")
    public String redirectToRegisterPage(){
        return "signUp";
    }

    @PostMapping("signUp")
    public String signUp(@Valid UserDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,String> errors = new HashMap<>();
            for(FieldError error: bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return "signUp";
        }
        service.signUp(dto);
        return "response";
    }

    @GetMapping("isEmailAvailable")
    public ResponseEntity<String> isEmailAvailable(@RequestParam("email") String email){
        UserDto dto=service.isEmailAvailble(email);
        if(dto.getId() !=0 ){
            return ResponseEntity.ok("Email is Available");
        }

        return ResponseEntity.ok("Email is not Available");
    }

    @GetMapping("isMobileNumberAvailable")
    public ResponseEntity<String> isMobileNumberAvailable(@RequestParam("mobileNumber") Long mobileNumber){
        UserDto dto = service.isMobileNumberAvailable(mobileNumber);
        if(dto.getId() != 0){
            return ResponseEntity.ok("Mobile Number is Available");
        }
        return ResponseEntity.ok("Mobile Number is not Available");
    }

    @GetMapping("checkEmailAvailableForLogin")
    public ResponseEntity<UserDto> checkEmailAvailableForLogin(@RequestParam("email") String email){
        UserDto dto = service.isEmailAvailble(email);
        if (dto.getId() != 0){
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("checkMobileAvailableForLogin")
    public ResponseEntity<UserDto> checkMobileAvailableForLogin(@RequestParam("mobileNumber") Long mobileNumber){
        UserDto dto = service.isMobileNumberAvailable(mobileNumber);
        if (dto.getId() != 0){
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.ok(dto);
    }
}
