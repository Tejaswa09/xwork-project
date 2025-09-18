package com.xworkz.rpapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "logininfo")
@AllArgsConstructor
@NoArgsConstructor
public class LoginEntity {
    @Id
    @Column(name = "slNo")
    Integer slNo;

    @Column(name = "emailOrMobileNumber")
    String emailOrMobileNumber;

    @Column(name = "password")
    String password;

    @Column(name = "date")
    String date;

    @Column(name="time")
    String time;
}
