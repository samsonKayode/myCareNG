package com.hypen.mycare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hypen.mycare.dao.AppointmentDAO;
import com.hypen.mycare.entity.Appointment;
import com.hypen.mycare.model.AppointmentModel;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDAO appointmentDAO;

	@Override
	@Transactional
	public void saveAppointment(Appointment theAppointment) {
		appointmentDAO.saveAppointment(theAppointment);

	}

	@Override
	@Transactional
	public List<Appointment> getAppointmentList(int profile_id) {
		List<Appointment> theList = appointmentDAO.getAppointmentList(profile_id);
		return theList;
	}

}
