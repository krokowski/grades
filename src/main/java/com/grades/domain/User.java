package com.grades.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    private String email;

    private String password;

    private String role;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private Long pesel;

    public User(User user) {
        this.userId = user.userId;
        this.email = user.email;
        this.password = user.password;
        this.role = user.role;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.pesel = user.pesel;
    }

}
