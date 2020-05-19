package com.hypen.mycare.dao;

import java.util.List;

import com.hypen.mycare.entity.Appointment;
import com.hypen.mycare.model.AppointmentModel;

public interface AppointmentDAO {
	
	public void saveAppointment(Appointment theAppointment);
	
	public List<Appointment> getAppointmentList(int profile_id);

}
