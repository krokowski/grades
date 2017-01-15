package com.grades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grades.dao.SubjectBlockDAO;
import com.grades.domain.Dictionary;
import com.grades.domain.SubjectBlock;
import com.grades.dto.SubjectBlockDTO;

@Service
public class SubjectBlockService {

	@Autowired
	private SubjectBlockDAO subjectBlockDAO;

	@Autowired
	private DictionaryService dictionaryService;

	public List<SubjectBlock> getAllSubjectBlocks() {
		List<SubjectBlock> subjectBlockList = new ArrayList<SubjectBlock>();
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findAll();
		Dictionary dictionary = dictionaryService.getDictionaries();

		for (SubjectBlockDTO subjectBlockDTO : subjectBlockDTOList) {
			SubjectBlock subjectBlock = new SubjectBlock(subjectBlockDTO);
			subjectBlock.setDescription(dictionaryService.generateDescription(dictionary, subjectBlockDTO));
			subjectBlockList.add(subjectBlock);
		}

		return subjectBlockList;
	}

	@Transactional
	public void createSubjectBlock(SubjectBlock subjectBlock) {
		SubjectBlockDTO subjectBlockDTO = new SubjectBlockDTO(subjectBlock);
		subjectBlockDAO.save(subjectBlockDTO);
	}

	/**
	 * Zwraca wszystkie subject-block'i, ktore dany student wybral
	 * 
	 * @param indexNo
	 * @return
	 */
	public List<SubjectBlock> getAllSelectedSubjectBlocks(Long indexNo) {
		List<SubjectBlock> subjectBlockList = new ArrayList<SubjectBlock>();
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findByIndexNo(indexNo);
		Dictionary dictionary = dictionaryService.getDictionaries();

		for (SubjectBlockDTO subjectBlockDTO : subjectBlockDTOList) {
			SubjectBlock subjectBlock = new SubjectBlock(subjectBlockDTO);
			subjectBlock.setDescription(dictionaryService.generateDescription(dictionary, subjectBlockDTO));
			subjectBlockList.add(subjectBlock);
		}

		return subjectBlockList;
	}

	/**
	 * Zwraca wszystkie subject-block'i, ktorych dany student nie wybral
	 * 
	 * @param studentId
	 * @return
	 */
	public List<SubjectBlock> getAllNonSelectedSubjectBlocks(Long indexNo) {
		List<SubjectBlock> subjectBlockList = new ArrayList<SubjectBlock>();
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findAllNonSelectedForStudent(indexNo);
		Dictionary dictionary = dictionaryService.getDictionaries();

		for (SubjectBlockDTO subjectBlockDTO : subjectBlockDTOList) {
			SubjectBlock subjectBlock = new SubjectBlock(subjectBlockDTO);
			subjectBlock.setDescription(dictionaryService.generateDescription(dictionary, subjectBlockDTO));
			subjectBlockList.add(subjectBlock);
		}

		return subjectBlockList;
	}

}
