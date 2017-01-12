package com.grades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grades.dao.GroupDAO;
import com.grades.dao.SubjectDAO;
import com.grades.dao.SubjectFormDAO;
import com.grades.domain.Dictionary;
import com.grades.domain.DictionaryElement;
import com.grades.dto.GroupDTO;
import com.grades.dto.SubjectDTO;
import com.grades.dto.SubjectFormDTO;

@Service
public class DictionaryService {
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private SubjectFormDAO subjectFormDAO;
	
	@Autowired
	private GroupDAO groupDAO;
	
	public Dictionary getDictionaries() {
		Iterable<SubjectDTO> subjectDTOList = subjectDAO.findAll();
		Iterable<SubjectFormDTO> subjectFormDTOList = subjectFormDAO.findAll();
		Iterable<GroupDTO> groupDTOList = groupDAO.findAll();
		Dictionary dictionary = new Dictionary();
		
		dictionary.setSubjectDict(subjectDTOList);
		dictionary.setSubjectFormDict(subjectFormDTOList);
		dictionary.setGroupDict(groupDTOList);
		
		return dictionary;
	}
	
	@Transactional
	public void createSubject(DictionaryElement dictionaryElement) {
		SubjectDTO subjectDTO = new SubjectDTO();
		subjectDTO.setName(dictionaryElement.getName());
		subjectDAO.save(subjectDTO);
	}
	
	@Transactional
	public void createSubjectForm(DictionaryElement dictionaryElement) {
		SubjectFormDTO subjectFormDTO = new SubjectFormDTO();
		subjectFormDTO.setName(dictionaryElement.getName());
		subjectFormDAO.save(subjectFormDTO);
	}
	
	@Transactional
	public void createGroup(DictionaryElement dictionaryElement) {
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setName(dictionaryElement.getName());
		groupDAO.save(groupDTO);
	}

}
