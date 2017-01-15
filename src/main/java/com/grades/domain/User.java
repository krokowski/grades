package com.grades.domain;

import com.grades.dto.UserDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	
	private Long userId;

    private String email;

    private String password;

    private String role;

    private String firstName;

    private String lastName;

    private Long pesel;
    
    private Long workerId;
    
    private Long indexNo;
    
    public User(UserDTO userDTO) {
    	this.userId = userDTO.getUserId();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.role = userDTO.getRole();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.pesel = userDTO.getPesel();
    }

}
