package com.grades.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grades.dto.WorkerDTO;

/**
 * @author Wojciech.Krokowski
 *
 */
@Repository
public interface WorkerDAO extends CrudRepository<WorkerDTO, Long> {

	WorkerDTO findByUserId(Long userId);
	
}
