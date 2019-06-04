package org.mvcorm.service;

import java.util.List;

import org.mvcorm.dao.UsersDAO;
import org.mvcorm.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	@Autowired
	UsersDAO usersDAO;

	public boolean saveOrUpdate(Users usersDTO) {
		return usersDAO.saveOrUpdate(usersDTO);
	}

	public List<Users> getAllUsersList() {
		return usersDAO.getAllUsers();
	}

	public boolean delete(Users usersDTO) {
		return usersDAO.deleteUsers(usersDTO);
	}
}
