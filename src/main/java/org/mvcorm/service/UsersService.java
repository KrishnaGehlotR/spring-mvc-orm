package org.mvcorm.service;

import java.util.List;

import org.mvcorm.dao.UsersDAO;
import org.mvcorm.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	@Autowired
	UsersDAO usersDAO;

	public boolean saveOrUpdate(UsersDTO usersDTO) {
		return usersDAO.saveOrUpdate(usersDTO);
	}

	public List<UsersDTO> getAllUsersList() {
		return usersDAO.getAllUsers();
	}

	public boolean delete(UsersDTO usersDTO) {
		return usersDAO.deleteUsers(usersDTO);
	}
}
