package com.travel.proj.app.login.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private Timestamp loginTime;

    private Timestamp logoutTime;

    private String auth;

    @Column(nullable = false)
    private String nickname;
}

