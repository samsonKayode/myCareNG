package com.hypen.mycare.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hypen.mycare.entity.Doctor;
import com.hypen.mycare.entity.PatientInfo;
import com.hypen.mycare.service.DoctorService;
import com.hypen.mycare.service.EmailService;
import com.hypen.mycare.service.PatientInfoService;
import com.hypen.mycare.success.SuccessEntity;

@RestController
@RequestMapping("/info")
public class DoctorRestController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientInfoService patientInfoService;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/doctors")
	public List<Doctor> getDoctorList(){
		
		List<Doctor> theList = doctorService.doctorList();
		return theList;
	}
	
	//get patient info..
	
	@GetMapping("/patient/{patient_id}")
	public PatientInfo getInfo(@PathVariable String patient_id) {
		
		PatientInfo theInfo = patientInfoService.getInfo(patient_id);
		
		return theInfo;
	}
	
	@GetMapping("/email/{email}/{message}")
	public SuccessEntity sendSimpleMail(@PathVariable String email, @PathVariable String message) {
		
		String subject="Your appointment at OxfordHealthPlus";
		
		String msg =""+message;
		SuccessEntity theSuccess=null;
		
		int a  = emailService.sendSimpleMessage(email, subject, msg);
		
		if(a==1) {
			theSuccess = new SuccessEntity(1, "Email Sent", System.currentTimeMillis());
		}else {
			theSuccess = new SuccessEntity(2, "Email Not Sent", System.currentTimeMillis());
		}
		
		return theSuccess;
		
	}



}
