package com.academy.it.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserResultDto {

    private String uuid;
    private String login;
    private String firstname;
    private String lastname;
}
