package com.grades.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.SubjectDTO;

@Repository
public interface SubjectDAO extends CrudRepository<SubjectDTO, Long> {

}
