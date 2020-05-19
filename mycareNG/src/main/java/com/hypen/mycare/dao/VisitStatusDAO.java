package com.hypen.mycare.dao;

import java.util.List;

import com.hypen.mycare.entity.VisitStatus;

public interface VisitStatusDAO {
	
	public int checkStatus(String patient_id);
	
	public List<VisitStatus> getStatus (String patient_id);

}
