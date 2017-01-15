package com.grades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grades.domain.GradeContext;
import com.grades.domain.Grades;
import com.grades.security.CustomUserDetails;
import com.grades.service.GradeService;

@Controller
public class GradeController {
  
  @Autowired
  private GradeService gradeService;
	
	@GetMapping(path = "/grades")
	public String getGradesList(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("studentSubjectList", gradeService.getStudentSubjectList(customUserDetails.getUserId()));
		return "";
	}
	
	@RequestMapping(path = "/ajax/get/grades")
	public List<GradeContext> getGrades(@RequestBody Grades grades) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return gradeService.getStudentGrades(customUserDetails.getUserId(), grades);
	}
	
	/*@PostMapping(path = "/grades")
	public String getGrades(@ModelAttribute("user") @Valid Grades grades, Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("grades", gradeService.getStudentGrades(grades, customUserDetails.getIndexNo()));
	  return "";
	}*/
	
	@GetMapping(path = "/grade/add")
	public String getGradeAddForm(Model model) {

	  return "";
	}

}
