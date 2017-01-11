package com.grades.security;

import com.grades.dao.UserDAO;
import com.grades.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO user=userDAO.findByEmail(email);
        if(null == user){
            throw new UsernameNotFoundException("No user present with email: " + email);
        }else{
            return new CustomUserDetails(user) {
            };
        }
    }
}
