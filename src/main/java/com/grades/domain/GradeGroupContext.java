package com.grades.domain;

import java.util.List;

import lombok.Data;

@Data
public class GradeGroupContext {
  
  private Long groupId;
  
  private Long workerId;
  
  private String groupName;
  
  private String workerFirstNameAndLastName;
  
  private List<GradeContext> gradeContextList;

}
