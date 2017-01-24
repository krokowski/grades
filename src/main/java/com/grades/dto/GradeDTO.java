package com.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.grades.domain.Grade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grade")
public class GradeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id")
    private Long gradeId;

    private int grade;

    private Date date;

    private String description;

    @Column(name = "student_subject_id")
    private Long studentSubjectId;    
    
    public GradeDTO(Grade grade) {
    	this.gradeId = grade.getGradeId();
    	this.grade = grade.getGrade();
    	DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    	try {
			this.date = df.parse(grade.getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	this.description = grade.getDescription();
    }

}
