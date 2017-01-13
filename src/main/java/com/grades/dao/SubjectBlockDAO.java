package com.grades.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.SubjectBlockDTO;

@Repository
public interface SubjectBlockDAO extends CrudRepository<SubjectBlockDTO, Long> {

	@Query("select * from subject_block sb, student_subject ss where ss.subject_block_id = sb.subject_block_id and "
			+ "ss.index_no <> ?1")
	List<SubjectBlockDTO> findAllNonSelectedForStudent(Long indexNo);
	
}
