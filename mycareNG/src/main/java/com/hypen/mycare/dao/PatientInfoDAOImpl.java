package com.hypen.mycare.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hypen.mycare.entity.PatientInfo;

@Repository
public class PatientInfoDAOImpl implements PatientInfoDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public PatientInfo getInfo(String patient_id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from PatientInfo where patient_id=:patient_id");
		theQuery.setParameter("patient_id", patient_id);
		
		PatientInfo theInfo = (PatientInfo) theQuery.getSingleResult();
		
		return theInfo;
	}

}
