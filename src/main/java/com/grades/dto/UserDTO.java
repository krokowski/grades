package com.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.grades.domain.User;
import com.grades.domain.UserRoleType;

import java.io.Serializable;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Long pesel;

    public UserDTO(UserDTO user) {
        this.userId = user.userId;
        this.email = user.email;
        this.password = user.password;
        this.role = user.role;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.pesel = user.pesel;
    }
    
    public UserDTO(User user) {
    	this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.pesel = user.getPesel();
    }

}
