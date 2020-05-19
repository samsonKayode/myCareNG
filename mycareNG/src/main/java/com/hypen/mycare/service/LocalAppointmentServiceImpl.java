package com.hypen.mycare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hypen.mycare.dao.EmailServiceDAO;
import com.hypen.mycare.dao.LocalAppointmentDAO;
import com.hypen.mycare.entity.LocalAppointment;

@Service
public class LocalAppointmentServiceImpl implements LocalAppointmentService {
	
	@Autowired
	LocalAppointmentDAO localAppointmentDAO;
	
	@Autowired
	EmailServiceDAO emailServiceDAO;

	@Override
	@Transactional
	public int saveLocalAppointment(LocalAppointment localAppointment) {
		
		LocalAppointment LA = new LocalAppointment();
		
		int a = localAppointmentDAO.saveLocalAppointment(localAppointment);
		
		return a;
	}

	@Override
	@Transactional
	public int checkAppointment(String patient_id, String date) {
		
		int a = localAppointmentDAO.checkAppointment(patient_id, date);
		
		return a;
	}

}
