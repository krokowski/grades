package com.grades.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Grade {

  private Long gradeId;

  private int grade;

  private Date date;

  private String description;
  
  private Long subjectBlockId;

  private Long indexNo;

}
