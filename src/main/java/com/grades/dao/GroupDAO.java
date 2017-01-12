package com.grades.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.GroupDTO;

@Repository
public interface GroupDAO extends CrudRepository<GroupDTO, Long> {

}
