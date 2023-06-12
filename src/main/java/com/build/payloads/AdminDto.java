package com.build.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminDto {

    private Integer adminId;
    private String adminName;
    private String adminPassword;

}
