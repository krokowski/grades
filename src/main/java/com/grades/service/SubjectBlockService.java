package com.grades.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grades.dao.GroupDAO;
import com.grades.dao.SubjectBlockDAO;
import com.grades.dao.SubjectDAO;
import com.grades.dao.SubjectFormDAO;
import com.grades.domain.Dictionary;
import com.grades.domain.DictionaryElement;
import com.grades.domain.SubjectBlock;
import com.grades.dto.GroupDTO;
import com.grades.dto.SubjectBlockDTO;
import com.grades.dto.SubjectDTO;
import com.grades.dto.SubjectFormDTO;

@Service
public class SubjectBlockService {
	
	@Autowired
	private SubjectBlockDAO subjectBlockDAO;
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private UserService userService;
	
	public List<SubjectBlock> getAllSubjectBlocks() {
		List<SubjectBlock> subjectBlockList = new ArrayList<SubjectBlock>();
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findAll();
		Dictionary dictionary = dictionaryService.getDictionaries();
		
		for (SubjectBlockDTO subjectBlockDTO : subjectBlockDTOList) {
			SubjectBlock subjectBlock = new SubjectBlock(subjectBlockDTO);
			subjectBlock.setDescription(generateDescription(dictionary, subjectBlockDTO));
			subjectBlockList.add(subjectBlock);
		}
		
		return subjectBlockList;
	}
	
	@Transactional
	public void createSubjectBlock(SubjectBlock subjectBlock) {
		SubjectBlockDTO subjectBlockDTO = new SubjectBlockDTO(subjectBlock);
		subjectBlockDAO.save(subjectBlockDTO);
	}
	
	private String generateDescription(Dictionary dictionary, SubjectBlockDTO subjectBlockDTO) {
		StringBuilder result = new StringBuilder();
		
		for (SubjectDTO subjectDTO : dictionary.getSubjectDict()) {
			if (subjectBlockDTO.getSubjectId().equals(subjectDTO.getSubjectId())) {
				result.append(subjectDTO.getName() + " ");
				break;
			}
		}
		
		for (SubjectFormDTO subjectFormDTO : dictionary.getSubjectFormDict()) {
			if (subjectBlockDTO.getSubjectFormId().equals(subjectFormDTO.getSubjectFormId())) {
				result.append(subjectFormDTO.getName() + " ");
				break;
			}
		}
		
		for (GroupDTO groupDTO : dictionary.getGroupDict()) {
			if (subjectBlockDTO.getGroupId().equals(groupDTO.getGroupId())) {
				result.append(groupDTO.getName() + " ");
				break;
			}
		}
		
		result.append(userService.getWorkerFirstNameAndLastName(subjectBlockDTO.getWorkerId()));
		
		return result.toString();
	}
	
}
