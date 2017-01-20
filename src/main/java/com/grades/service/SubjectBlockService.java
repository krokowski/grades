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

	public Boolean isUnique(SubjectBlock subjectBlock) {
		if (subjectBlockDAO.countOccurencies(subjectBlock.getSubjectId(), subjectBlock.getSubjectFormId(), subjectBlock.getGroupId()) > 0) {
			return false;
		} else {
			return true;
		}
	}

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
	 * @param userId
	 * @return
	 */
	public List<SubjectBlock> getAllSelectedByStudentSubjectBlocks(Long userId) {
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findAllSelectedForStudent(userId);
		List<SubjectBlock> subjectBlockList = getSubjectBlockListBySubjectBlockDTOList(subjectBlockDTOList);

		return subjectBlockList;
	}

	/**
	 * Zwraca wszystkie subject-block'i, ktorych dany student nie wybral
	 * 
	 * @param userId
	 * @return
	 */
	public List<SubjectBlock> getAllNonSelectedByStudentSubjectBlocks(Long userId) {
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findAllNonSelectedForStudent(userId);
		List<SubjectBlock> subjectBlockList = getSubjectBlockListBySubjectBlockDTOList(subjectBlockDTOList);

		return subjectBlockList;
	}

	public List<SubjectBlock> getAllCreatedByWorkerSubjectBlocks(Long userId) {
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findCreatedByWorker(userId);
		List<SubjectBlock> subjectBlockList = getSubjectBlockListBySubjectBlockDTOList(subjectBlockDTOList);

		return subjectBlockList;
	}

	private List<SubjectBlock> getSubjectBlockListBySubjectBlockDTOList(Iterable<SubjectBlockDTO> subjectBlockDTOList) {
		List<SubjectBlock> subjectBlockList = new ArrayList<SubjectBlock>();
		Dictionary dictionary = dictionaryService.getDictionaries();

		for (SubjectBlockDTO subjectBlockDTO : subjectBlockDTOList) {
			SubjectBlock subjectBlock = new SubjectBlock(subjectBlockDTO);
			subjectBlock.setDescription(dictionaryService.generateDescription(dictionary, subjectBlockDTO));
			subjectBlockList.add(subjectBlock);
		}

		return subjectBlockList;

	}

}
