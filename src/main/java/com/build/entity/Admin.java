package com.build.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    @Column(name = "adminName")
    private String adminName;

    @Column(name = "adminPassword")
    private String adminPassword;


//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
//    private List<User> users = new ArrayList<>();

}
