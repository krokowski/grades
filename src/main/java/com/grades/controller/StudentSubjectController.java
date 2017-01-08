package com.grades.controller;

import com.grades.dao.UserDAO;
import com.grades.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wojciech.Krokowski on 2017-01-06.
 */
@RestController
public class StudentSubjectController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = "/grade", produces = MediaType.APPLICATION_JSON_VALUE)
    public User test(){
        return userDAO.findOne(1L);
    }

}
