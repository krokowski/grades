package com.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

}
