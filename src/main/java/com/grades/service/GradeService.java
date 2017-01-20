package com.grades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grades.dao.GradeDAO;
import com.grades.dao.StudentSubjectDAO;
import com.grades.dao.SubjectBlockDAO;
import com.grades.domain.Dictionary;
import com.grades.domain.DictionaryElement;
import com.grades.domain.Grade;
import com.grades.domain.GradeContext;
import com.grades.domain.Grades;
import com.grades.domain.Student;
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
	
	@Autowired
	private StudentSubjectDAO studentSubjectDAO;
	
	@Autowired
	private UserService userService;

	/**
	 * Metoda uzywana do wygenerowania slownika z przedmiotami danego studenta
	 * 
	 * @param userId
	 * @return
	 */
	public List<DictionaryElement> getStudentSubjectList(Long userId) {
		List<DictionaryElement> studentSubjectList = new ArrayList<DictionaryElement>();
		DictionaryElement dictionaryElement = new DictionaryElement();
		Iterable<SubjectBlockDTO> subjectBlockDTOList = subjectBlockDAO.findAllSelectedForStudent(userId);
		Dictionary dictionary = dictionaryService.getDictionaries();

		for (SubjectBlockDTO subjectBlockDTO : subjectBlockDTOList) {
			dictionaryElement.setId(subjectBlockDTO.getSubjectBlockId());
			dictionaryElement.setName(dictionaryService.generateDescription(dictionary, subjectBlockDTO));
			studentSubjectList.add(dictionaryElement);
		}

		return studentSubjectList;
	}

	/**
	 * Wyszukuje wszystkie oceny danego studenta dla wybranego przedmiotu
	 * 
	 * @param grades
	 * @param userId
	 * @return
	 */
	public List<GradeContext> getStudentGrades(Long userId, Grades grades) {
		List<GradeContext> gradeContextList = new ArrayList<GradeContext>();
		List<GradeDTO> gradeDTOList = gradeDAO.findByUserIdAndSubjectBlockId(userId, grades.getStudentSubjectId());

		for (GradeDTO gradeDTO : gradeDTOList) {
			gradeContextList.add(new GradeContext(gradeDTO));
		}

		return gradeContextList;
	}
	
	public void addGrade(Grade grade) {
		GradeDTO gradeDTO = new GradeDTO(grade);
		gradeDTO.setStudentSubjectId(studentSubjectDAO.findByIndexNoAndSubjectBlockId(grade.getIndexNo(), grade.getSubjectBlockId()));
		gradeDAO.save(gradeDTO);
	}
	
	public List<Student> getStudents(Long subjectBlockId) {
		List<Student> studentList = new ArrayList<Student>();
		List<Long> indexNoList = studentSubjectDAO.findIndexNoBySubjectBlockId(subjectBlockId);
		
		for (Long indexNo : indexNoList) {
			studentList.add(new Student(indexNo, userService.getStudentDescription(indexNo)));
		}
		
		return studentList;
	}

}
