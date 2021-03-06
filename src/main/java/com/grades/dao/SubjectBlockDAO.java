package com.grades.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.SubjectBlockDTO;

@Repository
public interface SubjectBlockDAO extends CrudRepository<SubjectBlockDTO, Long> {

	@Query("select sb from SubjectBlockDTO sb where sb.subjectBlockId not in (select ss.subjectBlockId from StudentSubjectDTO ss, StudentDTO s "
			+ "where ss.indexNo = s.indexNo and s.userId = ?1)")
	Iterable<SubjectBlockDTO> findAllNonSelectedForStudent(Long userId);

	@Query("select sb from SubjectBlockDTO sb, StudentSubjectDTO ss where ss.subjectBlockId = sb.subjectBlockId and ss.studentSubjectId = ?1")
	SubjectBlockDTO findByStudentSubjectId(Long studentSubjectId);

	@Query("select sb from SubjectBlockDTO sb, StudentSubjectDTO ss, StudentDTO s where ss.subjectBlockId = sb.subjectBlockId "
			+ "and s.indexNo=ss.indexNo and s.userId = ?1")
	Iterable<SubjectBlockDTO> findAllSelectedForStudent(Long userId);

	@Query("select sb from SubjectBlockDTO sb, WorkerDTO w where w.workerId = sb.workerId and w.userId = ?1")
	Iterable<SubjectBlockDTO> findCreatedByWorker(Long userId);
	
	@Query("select count(*) from SubjectBlockDTO where subjectId = ?1 and subjectFormId = ?2 and groupId = ?3")
	int countOccurencies(Long subjectId, Long subjectFormId, Long groupId);

}