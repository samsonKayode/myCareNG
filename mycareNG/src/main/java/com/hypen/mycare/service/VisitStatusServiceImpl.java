package com.hypen.mycare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hypen.mycare.dao.VisitStatusDAO;
import com.hypen.mycare.entity.VisitStatus;

@Service
public class VisitStatusServiceImpl implements VisitStatusService {
	
	@Autowired
	 VisitStatusDAO visitStatusDAO;
	

	@Override
	@Transactional
	public int checkStatus(String patient_id) {
		int result = visitStatusDAO.checkStatus(patient_id);
		return result;
	}

	@Override
	@Transactional
	public List<VisitStatus> getStatus(String patient_id) {
		
		List<VisitStatus> theResult = visitStatusDAO.getStatus(patient_id);
		return theResult;
	}
	
}
