package com.hypen.mycare.service;

import com.hypen.mycare.entity.LocalAppointment;

public interface LocalAppointmentService {
	
	public int saveLocalAppointment(LocalAppointment localAppointment);
	
	public int checkAppointment(String patient_id, String date);

}
