package com.grades.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.StudentDTO;

@Repository
public interface StudentDAO extends CrudRepository<StudentDTO, Long> {

	StudentDTO findByUserId(Long userId);
	
}
