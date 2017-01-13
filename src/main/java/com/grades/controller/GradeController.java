package com.grades.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grades.domain.Grades;
import com.grades.domain.User;
import com.grades.service.GradeService;

@Controller
public class GradeController {
  
  @Autowired
  private GradeService gradeService;
	
	@GetMapping(path = "/grades")
	public String get(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("grades", gradeService.getStudentSubjectList(user.getIndexNo()));
		return "";
	}
	
	@PostMapping(path = "/grades")
	public String getGrades(@ModelAttribute("user") @Valid Grades grades, Model model) {
	  User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("grades", gradeService.getStudentGrades(grades, user.getIndexNo()));
	  return "";
	}
	
	@GetMapping(path = "/grade-add")
	public String getGradeAddForm(Model model) {

	  return "";
	}

}
