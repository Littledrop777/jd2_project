package com.academy.it.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppUserInfoDto {

    private String login;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthday;
    private String gender;

    public AppUserInfoDto(String login,
                          String firstname,
                          String lastname,
                          String email,
                          LocalDate birthday,
                          String gender) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }
}
