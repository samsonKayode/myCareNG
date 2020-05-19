package com.hypen.mycare.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hypen.mycare.entity.Appointment;
import com.hypen.mycare.model.AppointmentModel;
import com.hypen.mycare.service.AppointmentService;
import com.hypen.mycare.success.SuccessEntity;

@RestController
@RequestMapping("/appointments")
public class AppointmentRestController {
	
	@Autowired
	AppointmentService appointmentService;
	
	
	//Save appointment
	@PostMapping("/lists")
	public SuccessEntity saveAppointments(@RequestBody Appointment theAppointments) {
		
		SuccessEntity theSuccess;
		
		try {
			
			appointmentService.saveAppointment(theAppointments);
			theSuccess = new SuccessEntity(0, "Appointment Scheduled", System.currentTimeMillis());
			
		}
		catch(Exception cc) {
			
			theSuccess = new SuccessEntity(2, "Unable to save appointment "+cc.getMessage(), System.currentTimeMillis());
			
			cc.printStackTrace();
			
		}
		
		return theSuccess;
	}
	
	//get appointment list for single patient
	
	@GetMapping("/lists/{profile_id}")
	public List<Appointment> getAppointments(@PathVariable int profile_id) throws Exception{
		
		List<Appointment> theList = appointmentService.getAppointmentList(profile_id);
		
		return theList;
	}
	

}
