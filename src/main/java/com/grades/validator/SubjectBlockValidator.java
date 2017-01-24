package com.grades.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grades.domain.SubjectBlock;

public class SubjectBlockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SubjectBlock.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		//isUnique
		
	}

}
