package com.grades.domain;

import com.grades.dto.SubjectBlockDTO;

import lombok.Data;

@Data
public class SubjectBlock {
	
    private Long subjectBlockId;

    private Long subjectId;

    private Long subjectFormId;

    private Long groupId;

    private Long workerId;
    
    private String description;
    
    public SubjectBlock(SubjectBlockDTO subjectBlockDTO) {
    	this.subjectBlockId = subjectBlockDTO.getSubjectBlockId();
    	this.subjectId = subjectBlockDTO.getSubjectId();
    	this.subjectFormId = subjectBlockDTO.getSubjectFormId();
    	this.groupId = subjectBlockDTO.getGroupId();
    	this.workerId = subjectBlockDTO.getWorkerId();
    }

}
