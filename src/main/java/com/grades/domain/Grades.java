package com.grades.domain;

import java.util.List;

import lombok.Data;

@Data
public class Grades {
  
  private List<DictionaryElement> studentSubjectList;
  
  private Long subjectBlockId;

  private List<GradeContext> gradeContextList;
  
}
