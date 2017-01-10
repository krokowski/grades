package com.grades.controller;

import com.grades.dao.UserDAO;
import com.grades.domain.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wojciech.Krokowski on 2017-01-06.
 */
@Controller
public class StudentSubjectController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/login")
    public String test(HttpServletRequest request){
    	
        System.out.println("request ....");
        
        return "login";
    }

}
