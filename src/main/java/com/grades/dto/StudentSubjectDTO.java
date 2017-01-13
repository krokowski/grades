package com.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.grades.domain.StudentSubject;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_subject")
public class StudentSubjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_subject_id")
    private Long studentSubjectId;

    @Column(name = "student_block_id")
    private Long subjectBlockId;

    @Column(name = "index_no")
    private Long indexNo;
    
    public StudentSubjectDTO(StudentSubject studentSubject) {
    	this.studentSubjectId = studentSubject.getStudentSubjectId();
    	this.subjectBlockId = studentSubject.getSubjectBlockId();
    	this.indexNo = studentSubject.getIndexNo();
    }
    
}
