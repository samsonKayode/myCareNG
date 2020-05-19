package com.hypen.mycare.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hypen.mycare.entity.VisitStatus;
import com.hypen.mycare.service.VisitStatusService;
import com.hypen.mycare.success.SuccessEntity;

@RestController
@RequestMapping("/visit")
public class StatusRestController {
	
	@Autowired
	VisitStatusService visitStatusService;
	
	
	//Check existence of visit
	@GetMapping("/check/{patient_id}") 
	public SuccessEntity checkStatus(@PathVariable String patient_id){
		
		SuccessEntity successEntity = null;
		
		int ax = visitStatusService.checkStatus(patient_id);
		
		if(ax==0) {
			
			successEntity = new SuccessEntity(0, "EMPTY", System.currentTimeMillis());
		}else {
			
			successEntity = new SuccessEntity(0, "OK", System.currentTimeMillis());
		}
		
		return successEntity;
	}
	
	
	//get Visit list..
	@GetMapping("/list/{patient_id}")
	public List<VisitStatus> getStatusList(@PathVariable String patient_id){
		
		List<VisitStatus> theList = null;
		
		theList = visitStatusService.getStatus(patient_id);
		
		return theList;
		
	}

}
