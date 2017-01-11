package com.grades.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	public String getUserList(Model model) {
		model.addAttribute("usersList", userDAO.findAll());
		return "/user/list";
	}
	
	@GetMapping(path = "/{id}")
	public String getUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "/user/form";
	}
	
	@GetMapping(path = "/add")
	public String getUserForm() {
		return "/user/form";
	}
	
	@PostMapping(path = "/add")
	public String create(HttpServletRequest request, @ModelAttribute("user") @Valid User user, BindingResult result) {
		Long userId = userService.addUser(user);
		return String.format("redirect:/user/%d", userId);
	}

}
