package com.grades.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.SubjectBlockDTO;

@Repository
public interface SubjectBlockDAO extends CrudRepository<SubjectBlockDTO, Long> {

	@Query("select new com.grades.dto.SubjectBlockDTO(sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId) from SubjectBlockDTO sb, "
			+ "StudentSubjectDTO ss, StudentDTO s where ss.subjectBlockId = sb.subjectBlockId and s.indexNo=ss.indexNo and s.userId <> ?1")
	Iterable<SubjectBlockDTO> findAllNonSelectedForStudent(Long userId);

	@Query("select new com.grades.dto.SubjectBlockDTO(sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId) from SubjectBlockDTO sb, "
			+ "StudentSubjectDTO ss where ss.subjectBlockId = sb.subjectBlockId and ss.studentSubjectId = ?1")
	SubjectBlockDTO findByStudentSubjectId(Long studentSubjectId);

	@Query("select new com.grades.dto.SubjectBlockDTO(sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId) from SubjectBlockDTO sb, "
			+ "StudentSubjectDTO ss, StudentDTO s where ss.subjectBlockId = sb.subjectBlockId and s.indexNo=ss.indexNo and s.userId = ?1")
	Iterable<SubjectBlockDTO> findAllSelectedForStudent(Long userId);

	@Query("select new com.grades.dto.SubjectBlockDTO(sb.subjectBlockId, sb.subjectId, sb.subjectFormId, sb.groupId, sb.workerId) from SubjectBlockDTO sb, "
			+ "WorkerDTO w where w.workerId = sw.workerId and w.userId = ?1")
	Iterable<SubjectBlockDTO> findCreatedByWorker(Long userId);

}