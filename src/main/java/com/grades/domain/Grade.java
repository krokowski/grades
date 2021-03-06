package com.grades.domain;

import lombok.Data;

@Data
public class Grade {

  private Long gradeId;

  private int grade;

  private String date;

  private String description;
  
  private Long subjectBlockId;

  private Long indexNo;

}
