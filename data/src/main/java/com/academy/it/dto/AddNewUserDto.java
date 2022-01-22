package com.academy.it.dto;

import com.academy.it.validation.FieldEquals;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@FieldEquals(field = "password", equalsTo = "repeatPassword",
        message = "Password and repeated password does not equal")
public class AddNewUserDto {

    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be from 2 to 20 characters")
    @Pattern(regexp = "([A-Za-z]|[А-Яа-яЁё])*", message = "Name should contains only letters")
    private String firstname;
    @Pattern(regexp = "([A-Za-z]|[А-Яа-яЁё])*", message = "Surname should contains only letters")
    private String lastname;
    @NotBlank(message = "Username should not be empty")
    private String login;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Password should not be empty")
    @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "Password should contains at least one letter and digits")
    @Size(min = 8, message = "Password size should be at least 8 characters")
    private String password;
    @NotEmpty(message = "Repeat password should not be empty")
    private String repeatPassword;
    @Past(message = "Birthday should be valid")
    @NotNull(message = "Birthday should not be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    private String gender;
}
