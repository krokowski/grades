package com.grades.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.SubjectBlockDTO;

@Repository
public interface SubjectBlockDAO extends CrudRepository<SubjectBlockDTO, Long> {

	@Query("select sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId from SubjectBlockDTO sb, "
	    + "StudentSubjectDTO ss, StudentDTO s where ss.subjectBlockId = sb.subjectBlockId and s.indexNo=ss.indexNo and s.userId <> ?1")
	Iterable<SubjectBlockDTO> findAllNonSelectedForStudent(Long userId);
	
	@Query("select sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId from SubjectBlockDTO sb, "
      + "StudentSubjectDTO ss where ss.subjectBlockId = sb.subjectBlockId and ss.studentSubjectId = ?1")
	SubjectBlockDTO findByStudentSubjectId(Long studentSubjectId);
	
	@Query("select sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId from SubjectBlockDTO sb, "
      + "StudentSubjectDTO ss, StudentDTO s where ss.subjectBlockId = sb.subjectBlockId and s.indexNo=ss.indexNo and s.userId = ?1")
	List<SubjectBlockDTO> findByUserId(Long userId);
	
}
