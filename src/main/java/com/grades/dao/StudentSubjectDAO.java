package com.grades.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.StudentSubjectDTO;

@Repository
public interface StudentSubjectDAO extends CrudRepository<StudentSubjectDTO, Long> {

}
