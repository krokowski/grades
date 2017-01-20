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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grades.domain.Grade;
import com.grades.domain.GradeContext;
import com.grades.domain.Grades;
import com.grades.security.CustomUserDetails;
import com.grades.service.GradeService;
import com.grades.service.SubjectBlockService;

@Controller
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private SubjectBlockService subjectBlockService;

	@GetMapping(path = "/grades")
	public String getGradesList(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		model.addAttribute("studentSubjectList", gradeService.getStudentSubjectList(customUserDetails.getUserId()));
		return "grades/list";
	}

	@PostMapping(path = "/ajax/grades")
	public @ResponseBody List<GradeContext> getGrades(@RequestBody Grades grades) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return gradeService.getStudentGrades(customUserDetails.getUserId(), grades);
	}

	@GetMapping(path = "/grade/add")
	public String getGradeAddForm(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		model.addAttribute("subjectBlockList", subjectBlockService.getAllCreatedByWorkerSubjectBlocks(customUserDetails.getUserId()));
		return "grade/form";
	}

	@PostMapping(path = "/grade/add")
	public String addGrade(@ModelAttribute("grade") @Valid Grade grade, BindingResult result) {
		gradeService.addGrade(grade);
		return "";
	}

}
