package com.prajwal.backendtask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_id")
    private String emailID;

    @Column(name = "phone_number")
    private long mobNum;

    @Column(name = "address")
    private String address;

    @Column(name = "role")
    private String role;

}
