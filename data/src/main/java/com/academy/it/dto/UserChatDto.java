package com.academy.it.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserChatDto {

    private String userChatId;
    private String userId;
    private String userLogin;
    private String lastMessageFromLogin;
    private String message;
    private LocalDateTime createTime;
}
