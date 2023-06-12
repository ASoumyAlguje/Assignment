package com.build.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be of minimum 4 characters!!!")
    private String name;

    @NotEmpty
    @Size(min = 4, max = 8, message = "Passowrd must be min 4 and max 8 length!!!")
    private String password;

    @Email(message = "Email address is not valid!!!")
    private String email;

}
