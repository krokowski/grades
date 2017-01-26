package com.grades.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grades.domain.StudentSubject;
import com.grades.domain.SubjectBlock;
import com.grades.security.CustomUserDetails;
import com.grades.service.StudentSubjectService;
import com.grades.service.SubjectBlockService;

/**
 * Created by Wojciech.Krokowski on 2017-01-06.
 */
@Controller
@RequestMapping("/student-subject")
public class StudentSubjectController {

	@Autowired
	private SubjectBlockService subjectBlockService;
	
	@Autowired
	private StudentSubjectService studentSubjectService;
	

	@GetMapping
	public String getStudentSubjectList(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("subjectAddEmpty", false);
		model.addAttribute("subjectBlockList", subjectBlockService.getAllSelectedByStudentSubjectBlocks(customUserDetails.getUserId()));
		return "studentSubject/list";
	}

	@GetMapping(path = "/add")
	public String getStudentSubjectAddForm(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<SubjectBlock> subjectBlockList = subjectBlockService.getAllNonSelectedByStudentSubjectBlocks(customUserDetails.getUserId());
		if (subjectBlockList.isEmpty()) {
			model.addAttribute("subjectAddEmpty", true);
			model.addAttribute("subjectBlockList", subjectBlockService.getAllSelectedByStudentSubjectBlocks(customUserDetails.getUserId()));
			return "studentSubject/list";
		} else {
			model.addAttribute("subjectBlockList", subjectBlockList);
			return "studentSubject/form";
		}
	}

	@PostMapping(path = "/add")
	public String createStudentSubject(@ModelAttribute("studentSubject") @Valid StudentSubject studentSubject,
			BindingResult result) {
		studentSubjectService.createStudentSubject(studentSubject);
		return "redirect:/student-subject";
	}

}
