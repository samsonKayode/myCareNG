package com.hypen.mycare.dao;

import com.hypen.mycare.entity.LocalAppointment;

public interface LocalAppointmentDAO {
	
	public int saveLocalAppointment(LocalAppointment localAppointment);
	
	public int checkAppointment(String patient_id, String date);

}
