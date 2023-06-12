package com.build.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminDto {


    private Integer adminId;
    @NotBlank
    @Size(min = 4, max = 6)
    private String adminName;
    @NotEmpty
    @Size(min = 4, max = 8)
    private String adminPassword;

}
