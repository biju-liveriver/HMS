package com.lr.hms.multitenancy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.lr.hms.domain.User;

@Service
public class MultitenantService {
	
	  private SessionFactory sessionFactory;

	    public void save(User user) {
	    	sessionFactory.getCurrentSession().save(user);
	    }

	    public User getUser(Long id) {
	        return (User) sessionFactory.getCurrentSession().get(User.class, id);
	    }

	    public List<User> getUsers() {
	        return sessionFactory.getCurrentSession().createQuery("from User").list();
	    }
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
}
