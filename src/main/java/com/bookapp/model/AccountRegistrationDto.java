package com.bookapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_tbl")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountRegistrationDto {

    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Id
    @Column(name = "Mobile")
    private String mobileNumber;
    @Column(name = "Email")
    private String emailId;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "User_Name")
    private String userName;
    @Column(name = "Password")
    private String password;
}
