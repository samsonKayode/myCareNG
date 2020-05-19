package com.hypen.mycare.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hypen.mycare.entity.LocalAppointment;

@Repository
public class LocalAppointmentDAOImpl implements LocalAppointmentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int checkAppointment(String patient_id, String date) {
		
		int a=0;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from LocalAppointment where patient_id=:patient_id and date=:date");
		
		theQuery.setParameter("patient_id", patient_id);
		theQuery.setParameter("date", date);
		
		List<LocalAppointment> theList = theQuery.getResultList();
		a = theList.size();
		return a;
	}

	@Override
	public int saveLocalAppointment(LocalAppointment localAppointment) {
		
		int a=0;
		
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			currentSession.save(localAppointment);
			a = 1;
		}
		catch(Exception nn) {
			a = 2;
			System.out.println("Error saving appointments"+nn);
		}
		return a;
	}


}
