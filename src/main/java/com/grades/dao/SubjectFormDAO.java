package com.grades.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.SubjectFormDTO;

@Repository
public interface SubjectFormDAO extends CrudRepository<SubjectFormDTO, Long> {

}
