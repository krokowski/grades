package com.grades.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.SubjectBlockDTO;

@Repository
public interface SubjectBlockDAO extends CrudRepository<SubjectBlockDTO, Long> {

	@Query("select sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId from SubjectBlockDTO sb, "
	    + "StudentSubjectDTO ss where ss.subjectBlockId = sb.subjectBlockId and ss.indexNo <> ?1")
	Iterable<SubjectBlockDTO> findAllNonSelectedForStudent(Long indexNo);
	
}
