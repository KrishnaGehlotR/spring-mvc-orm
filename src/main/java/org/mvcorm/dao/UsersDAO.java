package org.mvcorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.mvcorm.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsersDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean saveOrUpdate(Users usersDTO) {
		sessionFactory.getCurrentSession().saveOrUpdate(usersDTO);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers(){
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}
	
	public boolean deleteUsers(Users usersDTO) {
		try {
			sessionFactory.getCurrentSession().delete(usersDTO);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
