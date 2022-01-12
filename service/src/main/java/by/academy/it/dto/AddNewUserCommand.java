package by.academy.it.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddNewUserCommand {

    private String firstname;
    private String lastname;
    private String login;
    private String email;
    private String password;
    private String repeatPassword;
    private LocalDate birthday;
    private String gender;
}
