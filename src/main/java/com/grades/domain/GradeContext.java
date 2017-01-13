package com.grades.domain;



import java.util.Date;

import com.grades.dto.GradeDTO;

import lombok.Data;

@Data
public class GradeContext {
  
  private int grade;
  
  private Date date;
  
  private String description;
  
  public GradeContext(GradeDTO gradeDTO) {
    this.grade = gradeDTO.getGrade();
    this.date = gradeDTO.getDate();
    this.description = gradeDTO.getDescription();
  }

}
