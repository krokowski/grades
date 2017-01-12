package com.grades.domain;

import com.grades.dto.GroupDTO;
import com.grades.dto.SubjectDTO;
import com.grades.dto.SubjectFormDTO;

import lombok.Data;

@Data
public class Dictionary {
	
	Iterable<SubjectDTO> subjectDict;
	
	Iterable<SubjectFormDTO> subjectFormDict;
	
	Iterable<GroupDTO> groupDict;

}
