package com.grades.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.StudentSubjectDTO;

@Repository
public interface StudentSubjectDAO extends CrudRepository<StudentSubjectDTO, Long> {
	
	@Query("select studentSubjectId from StudentSubjectDTO where indexNo = ?1 and subjectBlockId = ?2")
	Long findByIndexNoAndSubjectBlockId(Long indexNo, Long subjectBlockId);
	
	@Query("select indexNo from StudentSubjectDTO where subjectBlockId = ?1")
	List<Long> findIndexNoBySubjectBlockId(Long subjectBlockId);

}
