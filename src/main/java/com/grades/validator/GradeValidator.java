package com.grades.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grades.domain.Grade;

@Component("gradeValidator")
public class GradeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Grade.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		/*private Long gradeId;

		private int grade;

		private String date;

		private String description;

		private Long subjectBlockId;

		private Long indexNo;*/

	}

}
