package com.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.grades.domain.SubjectBlock;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject_block")
public class SubjectBlockDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_block_id")
    private Long subjectBlockId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_form_id")
    private Long subjectFormId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "worker_id")
    private Long workerId;
    
    public SubjectBlockDTO(SubjectBlock subjectBlock) {
    	this.subjectBlockId = subjectBlock.getSubjectBlockId();
    	this.subjectId = subjectBlock.getSubjectId();
    	this.subjectFormId = subjectBlock.getSubjectFormId();
    	this.groupId = subjectBlock.getGroupId();
    	this.workerId = subjectBlock.getWorkerId();
    }
    
}
