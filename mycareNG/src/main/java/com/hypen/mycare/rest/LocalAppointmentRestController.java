package com.hypen.mycare.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hypen.mycare.entity.LocalAppointment;
import com.hypen.mycare.service.LocalAppointmentService;
import com.hypen.mycare.success.SuccessEntity;

@RestController
@RequestMapping("/localappointment")
public class LocalAppointmentRestController {
	
	@Autowired
	LocalAppointmentService localAppointmentService;
	
	
	@PostMapping("/book")
	public SuccessEntity saveLocalAppointment(@RequestBody LocalAppointment localAppointment) {
		SuccessEntity successEntity = null;
		
		int a = localAppointmentService.saveLocalAppointment(localAppointment);
		
		
		if(a==1) {
			//saved..
			
			successEntity = new SuccessEntity(1, "Appointment Scheduled ", System.currentTimeMillis());
		}else {
			successEntity = new SuccessEntity(2, "Error scheduling appointment ", System.currentTimeMillis());
		}
		
		return successEntity;
	}
	
	@GetMapping("/book/{patient_id}/{date}")
	public SuccessEntity checkData(@PathVariable String patient_id, @PathVariable String date) {
		
		SuccessEntity successEntity = null;
		
		int a = localAppointmentService.checkAppointment(patient_id, date);
		
		if(a==0) {
			//saved..
			
			successEntity = new SuccessEntity(1, "EMPTY", System.currentTimeMillis());
		}else {
			successEntity = new SuccessEntity(2, "NOT EMPTY", System.currentTimeMillis());
		}
		
		return successEntity;
	}

}
