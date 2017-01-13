package com.grades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grades.dao.StudentSubjectDAO;
import com.grades.domain.StudentSubject;
import com.grades.dto.StudentSubjectDTO;

@Service
public class StudentSubjectService {

	@Autowired
	private StudentSubjectDAO studentSubjectDAO;
	
	@Transactional
	public void createStudentSubject(StudentSubject studentSubject) {
		StudentSubjectDTO studentSubjectDTO = new StudentSubjectDTO(studentSubject);
		studentSubjectDAO.save(studentSubjectDTO);
	}
	
}
