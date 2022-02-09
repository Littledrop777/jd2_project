package com.academy.it.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserInfoDto {

    private String login;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthday;
    private String gender;
    private String avatarId;
}
