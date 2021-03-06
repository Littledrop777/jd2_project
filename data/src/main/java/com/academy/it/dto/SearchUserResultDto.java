package com.academy.it.dto;

import com.academy.it.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchUserResultDto {

    private String uuid;
    private String login;
    private String firstname;
    private String lastname;
    private Status status;

    public SearchUserResultDto(String uuid, String login, String firstname, String lastname) {
        this.uuid = uuid;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
