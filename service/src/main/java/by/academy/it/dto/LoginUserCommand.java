package by.academy.it.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginUserCommand {

    @NotEmpty(message = "Login is empty")
    private String login;
    @NotEmpty(message = "Password is empty")
    private String password;
}
