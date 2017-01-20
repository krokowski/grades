package com.grades.dao;

import org.springframework.data.jpa.repository.Query;
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
	
	@Query("select workerId from WorkerDTO where userId = ?1")
	Long findWorkerIdByUserId(Long userId);
	
	@Query("select userId from WorkerDTO where workerId = ?1")
	Long findByWorkerId(Long workerId);
	
}
