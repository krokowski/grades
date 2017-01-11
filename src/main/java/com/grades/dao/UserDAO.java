package com.grades.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.UserDTO;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Repository
public interface UserDAO extends CrudRepository<UserDTO, Long> {

    UserDTO findByEmail(String email);
    
    UserDTO findByUserId(Long userId);

}
