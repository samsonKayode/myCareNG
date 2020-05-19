package com.hypen.mycare.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hypen.mycare.entity.VisitStatus;

@Repository
public class VisitStatusDAOImpl implements VisitStatusDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int checkStatus(String patient_id) {
		
		int result=0;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<VisitStatus> theQuery = currentSession.createQuery("from VisitStatus where patient_id=:patient_id and date=CONVERT(VARCHAR(10), getdate(), 111) ORDER by id asc");
		theQuery.setParameter("patient_id", patient_id);
		
		List<VisitStatus> theResult = theQuery.getResultList();
		
		result = theResult.size();
		
		return result;
	}

	@Override
	public List<VisitStatus> getStatus(String patient_id) {
		
		int result=0;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<VisitStatus> theQuery = currentSession.createQuery("from VisitStatus where patient_id=:patient_id and date=CONVERT(VARCHAR(10), getdate(), 111) order by id asc");
		theQuery.setParameter("patient_id", patient_id);
		
		List<VisitStatus> theResult = theQuery.getResultList();
	
		return theResult;
	}

}
