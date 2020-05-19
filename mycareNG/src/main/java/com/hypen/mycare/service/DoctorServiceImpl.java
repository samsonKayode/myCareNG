package com.hypen.mycare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hypen.mycare.dao.DoctorDAO;
import com.hypen.mycare.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorDAO doctorDAO;

	@Override
	@Transactional
	public List<Doctor> doctorList() {
		List<Doctor> theList = doctorDAO.doctorList();
		return theList;
	}
	
	

}
