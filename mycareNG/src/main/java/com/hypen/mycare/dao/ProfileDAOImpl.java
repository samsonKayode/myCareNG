package com.hypen.mycare.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.hypen.mycare.entity.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private SessionFactory sessionFactory;
	


	@Override
	public int saveProfile(Profile theProfile) {
		
		int a=0;
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(theProfile);
			
			a = 1;
		}
		
		
		catch(Exception nn) {
			a = 0;
			System.out.println("Error saving profile"+nn);
			nn.printStackTrace();
		}
		
		return a;
		
	}


	@Override
	public List<Profile> checkEmail(String email, String password) {
		
		int theResult;

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Profile where email=:emailId and password=:passwordId");
		theQuery.setParameter("emailId", email);
		theQuery.setParameter("passwordId", password);
		
		List<Profile> theList = theQuery.getResultList();
		
		
		return theList;
	}


}
