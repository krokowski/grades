package com.grades.dao;

import com.grades.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
