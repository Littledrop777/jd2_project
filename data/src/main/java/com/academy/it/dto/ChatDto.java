package com.academy.it.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {

    private String userId;
    private String login;
    private String message;
    private LocalDateTime createTime;
}
