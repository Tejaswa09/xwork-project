package com.xworkz.rpapp.entity;

import com.xworkz.rpapp.enums.Gender;
import lombok.Data;


import javax.persistence.*;


import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name="getDetailsByEmail",query = "from UserEntity where email =: mail "),
        @NamedQuery(name="getDetailsByMobileNumber",query = "from UserEntity where mobileNumber =:mobileNumber")
})
public class UserEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name="First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name="Mobile_Number")
    private Long mobileNumber;

    @Column(name = "Dob")
    private LocalDate dateOfBirth;

    @Column(name = "Country")
    private  String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "State")
    private String state;

    @Column(name = "City")
    private String city;

    @Column(name = "Pincode")
    private int pincode;

    @Column(name="Password")
    private String password;
}
