package com.grades.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grades.domain.SubjectBlock;
import com.grades.service.SubjectBlockService;

@Component("subjectBlockValidator")
public class SubjectBlockValidator implements Validator {
	
	@Autowired
	private SubjectBlockService subjectBlockService;

	@Override
	public boolean supports(Class<?> clazz) {
		return SubjectBlock.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SubjectBlock subjectBlock = (SubjectBlock) target;
		
		if (!subjectBlockService.isUnique(subjectBlock)) {
			// 
		}
		
	}

}
