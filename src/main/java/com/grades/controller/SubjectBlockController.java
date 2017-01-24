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

import com.grades.dao.WorkerDAO;
import com.grades.domain.Dictionary;
import com.grades.domain.DictionaryElement;
import com.grades.domain.SubjectBlock;
import com.grades.security.CustomUserDetails;
import com.grades.service.DictionaryService;
import com.grades.service.SubjectBlockService;

/**
 * @author Wojciech.Krokowski
 *
 */
@Controller
@RequestMapping("/subject-block")
public class SubjectBlockController {

	@Autowired
	private SubjectBlockService subjectBlockService;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private WorkerDAO workerDAO;

	@GetMapping
	public String getSubjectBlockList(Model model) {
		model.addAttribute("subjectBlockList", subjectBlockService.getAllSubjectBlocks());
		return "subjectBlock/list";
	}

	@GetMapping(path = "/add")
	public String getSubjectBlockAddForm(Model model) {
		Dictionary dictionary = dictionaryService.getDictionaries();
		model.addAttribute("subjectDictionary", dictionary.getSubjectDict());
		model.addAttribute("subjectFormDictionary", dictionary.getSubjectFormDict());
		model.addAttribute("groupDictionary", dictionary.getGroupDict());
		return "subjectBlock/form";
	}

	@PostMapping(path = "/add")
	public String createSubjectBlock(@ModelAttribute("subjectBlock") SubjectBlock subjectBlock) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		//if (subjectBlockService.isUnique(subjectBlock)) {
			subjectBlock.setWorkerId(workerDAO.findWorkerIdByUserId(customUserDetails.getUserId()));
			subjectBlockService.createSubjectBlock(subjectBlock);
			return "redirect:/subject-block";
	}

	@GetMapping(path = "/add-subject")
	public String getSubjectAddForm() {
		return "subjectBlock/addSubjectBlockComponent";
	}

	@PostMapping(path = "/add-subject")
	public String createSubject(HttpServletRequest request,
			@ModelAttribute("dictionaryElement") @Valid DictionaryElement dictionaryElement, BindingResult result) {
		dictionaryService.createSubject(dictionaryElement);
		return "redirect:/subject-block";
	}

	@GetMapping(path = "/add-subject-form")
	public String getSubjectFormAddForm() {
		return "subjectBlock/addSubjectBlockComponent";
	}

	@PostMapping(path = "/add-subject-form")
	public String createSubjectForm(HttpServletRequest request,
			@ModelAttribute("dictionaryElement") @Valid DictionaryElement dictionaryElement, BindingResult result) {
		dictionaryService.createSubjectForm(dictionaryElement);
		return "redirect:/subject-block";
	}

	@GetMapping(path = "/add-group")
	public String getGroupAddForm() {
		return "subjectBlock/addSubjectBlockComponent";
	}

	@PostMapping(path = "/add-group")
	public String createGroup(HttpServletRequest request,
			@ModelAttribute("dictionaryElement") @Valid DictionaryElement dictionaryElement, BindingResult result) {
		dictionaryService.createGroup(dictionaryElement);
		return "redirect:/subject-block";
	}

}
