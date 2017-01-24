package com.grades.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.grades.domain.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		//ValidationUtils.rejectIfEmpty(errors, field, errorCode);
		//errors.rejectValue(field, errorCode);
		
		/*private Long userId;

	    private String email;

	    private String password;

	    private String role;

	    private String firstName;

	    private String lastName;

	    private Long pesel;
	    
	    private Long workerId;
	    
	    private Long indexNo;*/
		
	}

}
