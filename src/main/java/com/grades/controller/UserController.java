package com.grades.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grades.dao.UserDAO;
import com.grades.domain.User;
import com.grades.service.UserService;

/**
 * @author Wojciech.Krokowski
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator userValidator;

	@GetMapping
	public String getUserList(Model model) {
		model.addAttribute("usersList", userDAO.findAll());
		return "user/list";
	}

	@GetMapping(path = "/add")
	public String getUserForm() {
		return "user/form";
	}

	@PostMapping(path = "/add")
	public String create(@ModelAttribute("user") @Valid User user, BindingResult result) {
		
		userService.addUser(user);
		return "redirect:/user";
	}

}
