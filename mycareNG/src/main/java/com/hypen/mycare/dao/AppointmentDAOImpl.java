package com.hypen.mycare.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hypen.mycare.entity.Appointment;
import com.hypen.mycare.model.AppointmentModel;
import com.hypen.mycare.utils.SessionGenerator;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {
	
	@Autowired 
	SessionFactory sessionFactory;

	@Override
	public void saveAppointment(Appointment theAppointment) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String code = SessionGenerator.nextSessionId().toUpperCase();
		
		theAppointment.setCode(code);	
		session.save(theAppointment);

	}

	@Override
	public List<Appointment> getAppointmentList(int profile_id) {
		
		String sqlString="select id, profile_id, hospitalName, hospitalAddress, department, DATE_FORMAT(date, '%D %b %Y') date, time, doctorName, code, status \n" + 
				"from appointments where profile_id=:profile_id order by id desc";
		
		Session session = sessionFactory.getCurrentSession();
		Query<Appointment> theQuery = session.createQuery("from Appointment h where profile_id=:profile_id order by h.id desc", Appointment.class);
		//Query<Appointment> theQuery = session.createNativeQuery(sqlString);
		
		theQuery.setParameter("profile_id", profile_id);
		
		List<Appointment> theList = theQuery.getResultList();
		return theList;
	}

}
