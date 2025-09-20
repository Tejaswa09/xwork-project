package com.xworkz.rpapp.controller;


import com.xworkz.rpapp.dto.UserDto;
import com.xworkz.rpapp.service.RPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class ReethuPickelsController {
    @Autowired
    RPService service;

    @GetMapping("loginPage")
    public String redirectToRegisterPage(){
        return "login";
    }

    @PostMapping("signUp")
    public String signUp(@Valid UserDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,String> errors = new HashMap<>();
            for(FieldError error: bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
                System.out.println(errors.get(error.getField()));
            }


            return "signUp";
        }
        service.signUp(dto);
        return "login";
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

    @PostMapping("loginValidation")
    public String loginValidation(@RequestParam("emailOrMobileNumber") String emailOrMobileNumber, @RequestParam("password") String password, Model model){
       String statusMessage= service.loginValidation(emailOrMobileNumber,password);
       model.addAttribute("email",emailOrMobileNumber);
       model.addAttribute("statusMessage",statusMessage);
       if(statusMessage.equals("Username not found")){
           return "login";
       }else if(statusMessage.equals("Invalid Mobile") || statusMessage.equals("Invalid email")){
            return "login";
        }else if(statusMessage.equals("login UnSuccessful")){
            model.addAttribute("passwordStatusMessage","Incorrect Password");
            return "login";
        }else{
            model.addAttribute("statusMessage","");
           model.addAttribute("passwordStatusMessage","");
            return "dashboard";
        }
    }

    @PostMapping("directToHome")
    public String loginToHome(){
        return "index";
    }
}
