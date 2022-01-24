package com.academy.it.dto;

import com.academy.it.validation.FieldEquals;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@FieldEquals(field = "password", equalsTo = "repeatPassword",
        message = "Password and repeated password does not equal")
public class UpdateUserDto {

    private String firstname;
    private String lastname;
    private String login;
    private String email;
    private String password;
    private String repeatPassword;
    @Past(message = "Birthday should be valid")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    private String gender;
}
