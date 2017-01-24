package com.grades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grades.dao.StudentDAO;
import com.grades.dao.StudentSubjectDAO;
import com.grades.domain.StudentSubject;
import com.grades.dto.StudentDTO;
import com.grades.dto.StudentSubjectDTO;
import com.grades.security.CustomUserDetails;

@Service
public class StudentSubjectService {

	@Autowired
	private StudentSubjectDAO studentSubjectDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Transactional
	public void createStudentSubject(StudentSubject studentSubject) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		StudentSubjectDTO studentSubjectDTO = new StudentSubjectDTO(studentSubject);
		StudentDTO studentDTO = studentDAO.findByUserId(customUserDetails.getUserId());
		studentSubjectDTO.setIndexNo(studentDTO.getIndexNo());
		studentSubjectDAO.save(studentSubjectDTO);
	}
	
}
