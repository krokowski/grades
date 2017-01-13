package com.grades.controller;

import javax.servlet.http.HttpServletRequest;
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
import com.grades.domain.User;
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
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("subjectBlockList", subjectBlockService.getAllNonSelectedSubjectBlocks(user.getIndexNo()));
		return "";
	}

	@GetMapping(path = "/add")
	public String getStudentSubjectAddForm() {
		return "";
	}

	@PostMapping(path = "/add")
	public String createStudentSubject(HttpServletRequest request, @ModelAttribute("studentSubject") @Valid StudentSubject studentSubject,
			BindingResult result) {
		studentSubjectService.createStudentSubject(studentSubject);
		return "";
	}

}
