package com.grades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grades.dao.StudentDAO;
import com.grades.dao.UserDAO;
import com.grades.dao.WorkerDAO;
import com.grades.domain.User;
import com.grades.domain.UserRoleType;
import com.grades.dto.StudentDTO;
import com.grades.dto.UserDTO;
import com.grades.dto.WorkerDTO;

/**
 * @author Wojciech.Krokowski
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private WorkerDAO workerDAO;

	public User getUser(Long userId) {
		User user = new User(userDAO.findByUserId(userId));

		if (UserRoleType.ROLE_STUDENT.toString().equals(user.getRole())) {
			user.setIndexNo(studentDAO.findByUserId(userId).getIndexNo());
		} else if (UserRoleType.ROLE_WORKER.toString().equals(user.getRole())) {
			user.setWorkerId(workerDAO.findByUserId(userId).getWorkerId());
		}

		return user;
	}

	@Transactional
	public void addUser(User user) {
		UserDTO userDTO = new UserDTO(user);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDTO.setPassword(passwordEncoder.encode(user.getPassword()));

		userDTO = userDAO.save(userDTO);

		if (UserRoleType.ROLE_STUDENT.toString().equals(user.getRole())) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setIndexNo(user.getIndexNo());
			studentDTO.setUserId(userDTO.getUserId());
			studentDAO.save(studentDTO);
		} else if (UserRoleType.ROLE_WORKER.toString().equals(user.getRole())) {
			WorkerDTO workerDTO = new WorkerDTO();
			workerDTO.setUserId(userDTO.getUserId());
			workerDAO.save(workerDTO);
		}
	}

	public String getWorkerFirstNameAndLastName(Long workerId) {
		StringBuilder result = new StringBuilder();
		Long userId = workerDAO.findByWorkerId(workerId);
		UserDTO userDTO = userDAO.findByUserId(userId);

		result.append(userDTO.getFirstName());
		result.append(" ");
		result.append(userDTO.getLastName());

		return result.toString();
	}
	
	public String getStudentDescription(Long indexNo) {
		UserDTO userDTO = userDAO.findByIndexNo(indexNo);
		StringBuilder sb = new StringBuilder();
		sb.append(userDTO.getFirstName());
		sb.append(" ");
		sb.append(userDTO.getLastName());
		sb.append(" ");
		sb.append(indexNo);
		return sb.toString();
	}

}
