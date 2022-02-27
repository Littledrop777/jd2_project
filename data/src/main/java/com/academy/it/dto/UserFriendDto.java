package com.academy.it.dto;

import com.academy.it.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendDto {

    private String id;
    private String login;
    private String firstname;
    private String lastname;
    private Status status;
}
