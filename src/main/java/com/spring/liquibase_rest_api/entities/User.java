package com.spring.liquibase_rest_api.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    public String toString(){
        return "Users Id: " + id + "\n" + "First Name: " + firstName + "\n"
             + "Last Name: " + lastName + "\n" + "Birth Date: " + birthDate + "\n"
             + "Email: " + email + "\n" + "Password: " + password + "\n";
    }
}
