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

	public boolean saveOrUpdate(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	public boolean deleteUsers(Users users) {
		try {
			sessionFactory.getCurrentSession().delete(users);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String getUsernameById(Integer identifier) {
		return (String) sessionFactory.getCurrentSession()
				.createQuery("SELECT username FROM Users WHERE userId=:Identifier")
				.setParameter("Identifier", identifier).uniqueResult();
	}
}
