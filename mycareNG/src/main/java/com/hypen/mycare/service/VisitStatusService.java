package com.hypen.mycare.service;

import java.util.List;

import com.hypen.mycare.entity.VisitStatus;

public interface VisitStatusService {
	
	public int checkStatus(String patient_id);
	
	public List<VisitStatus> getStatus (String patient_id);

}
