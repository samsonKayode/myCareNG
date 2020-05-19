package com.hypen.mycare.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hypen.mycare.entity.Doctor;

@Repository
public class DoctorDAOImpl implements DoctorDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Doctor> doctorList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Doctor where status='ACTIVE' order by lastname asc"); 
		
		List<Doctor> theList = theQuery.getResultList();
		
		return theList;
	}
	
	

}
