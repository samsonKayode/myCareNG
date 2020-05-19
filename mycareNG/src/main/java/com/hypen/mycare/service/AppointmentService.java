package com.hypen.mycare.service;

import java.util.List;

import com.hypen.mycare.entity.Appointment;
import com.hypen.mycare.model.AppointmentModel;

public interface AppointmentService {
	
	public void saveAppointment(Appointment theAppointment);
	
	public List<Appointment> getAppointmentList(int profile_id);

}
