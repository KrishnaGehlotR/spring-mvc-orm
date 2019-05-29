package org.mvcorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.mvcorm.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsersDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean saveOrUpdate(UsersDTO usersDTO) {
		sessionFactory.getCurrentSession().saveOrUpdate(usersDTO);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<UsersDTO> getAllUsers(){
		return sessionFactory.getCurrentSession().createQuery("from users").list();
	}
	
	public boolean deleteUsers(UsersDTO usersDTO) {
		try {
			sessionFactory.getCurrentSession().delete(usersDTO);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
