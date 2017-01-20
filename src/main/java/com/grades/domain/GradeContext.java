package com.grades.domain;

import java.text.SimpleDateFormat;

import com.grades.dto.GradeDTO;

import lombok.Data;

@Data
public class GradeContext {

	private int grade;

	private String date;

	private String description;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");


	public GradeContext(GradeDTO gradeDTO) {
		this.grade = gradeDTO.getGrade();
		this.date = formatter.format(gradeDTO.getDate());
		this.description = gradeDTO.getDescription();
	}

}
