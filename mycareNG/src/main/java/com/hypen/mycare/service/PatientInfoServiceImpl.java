package com.hypen.mycare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hypen.mycare.dao.PatientInfoDAO;
import com.hypen.mycare.entity.PatientInfo;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {
	
	@Autowired
	PatientInfoDAO patientInfoDAO;

	@Override
	@Transactional
	public PatientInfo getInfo(String patient_id) {
		
		PatientInfo theInfo = patientInfoDAO.getInfo(patient_id);
		return theInfo;
	}

}
