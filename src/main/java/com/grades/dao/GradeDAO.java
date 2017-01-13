package com.grades.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.GradeDTO;

@Repository
public interface GradeDAO extends CrudRepository<GradeDTO, Long> {
  
  @Query("select g.grade, g.date, g.description from GradeDTO g, StudentSubjectDTO ss where g.studentSubjectId = ss.studentSubjectId "
      + "and ss.indexNo = ?1")
  List<GradeDTO> findAllGradesForStudent(Long indexNo);
  
  @Query("select g.grade, g.date, g.description from GradeDTO g, StudentSubjectDTO ss where g.studentSubjectId = ss.studentSubjectId "
      + "and ss.indexNo = ?1 and ss.subjectBlockId = ?2")
  List<GradeDTO> findByIndexNoAndSubjectBlockId(Long indexNo, Long subjectBlockId);

}
