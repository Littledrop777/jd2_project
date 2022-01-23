package com.academy.it.dto;

import lombok.Data;

@Data
public class SearchUserResultDto {

    private String login;
    private String firstname;
    private String lastname;

    public SearchUserResultDto(String login, String firstname, String lastname) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
