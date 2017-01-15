package com.grades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grades.dao.GradeDAO;
import com.grades.dao.SubjectBlockDAO;
import com.grades.domain.Dictionary;
import com.grades.domain.DictionaryElement;
import com.grades.domain.GradeContext;
import com.grades.domain.Grades;
import com.grades.dto.GradeDTO;
import com.grades.dto.SubjectBlockDTO;

@Service
public class GradeService {

	@Autowired
	private GradeDAO gradeDAO;

	@Autowired
	private SubjectBlockDAO subjectBlockDAO;

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * Metoda uzywana do wygenerowania slownika z przedmiotami danego studenta
	 * 
	 * @param userId
	 * @return
	 */
	public Grades getStudentSubjectList(Long userId) {
		Grades grades = new Grades();
		DictionaryElement dictionaryElement = new DictionaryElement();
		List<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findByUserId(userId);
		Dictionary dictionary = dictionaryService.getDictionaries();

		for (SubjectBlockDTO subjectBlockDTO : subjectBlockDTOList) {
			dictionaryElement.setId(subjectBlockDTO.getSubjectBlockId());
			dictionaryElement.setName(dictionaryService.generateDescription(dictionary, subjectBlockDTO));
			grades.getStudentSubjectList().add(dictionaryElement);
		}

		return grades;
	}

	/**
	 * Wyszukuje wszystkie oceny danego studenta, dla wybranego przedmiotu
	 * 
	 * @param grades
	 * @param userId
	 * @return
	 */
	public List<GradeContext> getStudentGrades(Long userId, Grades grades) {
		List<GradeContext> gradeContextList = new ArrayList<GradeContext>();
		List<GradeDTO> gradeDTOList = gradeDAO.findByUserIdAndSubjectBlockId(userId, grades.getSubjectBlockId());

		for (GradeDTO gradeDTO : gradeDTOList) {
			gradeContextList.add(new GradeContext(gradeDTO));
		}

		return gradeContextList;
	}

}
