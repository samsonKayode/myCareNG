package com.hypen.mycare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hypen.mycare.dao.HospitalDAO;
import com.hypen.mycare.entity.HospitalAddress;
import com.hypen.mycare.entity.HospitalDoctor;
import com.hypen.mycare.entity.HospitalSpeciality;
import com.hypen.mycare.entity.Hospitals;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	HospitalDAO hospitalDAO;

	//Add new hospital
	
	@Override
	@Transactional
	public Hospitals saveHospital(Hospitals theHospital) {
		
		 hospitalDAO.saveHospital(theHospital);
		
		return theHospital;
	}

	//Get List of hospitals
	
	@Override
	@Transactional
	public List<Hospitals> getHospitalList() {
		
		List<Hospitals> theList = hospitalDAO.getHospitalList();
		
		return theList;
	}

	//Save new hospital address..
	
	@Override
	@Transactional
	public Hospitals saveHospitalAddress(HospitalAddress theAddress, int hospital_id) {
		
		
		Hospitals hadd = hospitalDAO.saveHospitalAddress(theAddress, hospital_id);
		
		if(hadd.getHospitalSpeciality().isEmpty()) {
			hadd.setHospitalSpeciality(null);
		}
		
		if(hadd.getHospitalDoctor().isEmpty()) {
			hadd.setHospitalDoctor(null);
		}
		
		
		
		return hadd;
	}

	@Override
	@Transactional
	public Hospitals getSingle(int hospital_id) {
		Hospitals theHospitals = hospitalDAO.getSingle(hospital_id);
		return theHospitals;
	}

	
	//Save Speciality..
	
	@Override
	@Transactional
	public Hospitals saveSpeciality(HospitalSpeciality theSpeciality, int hospital_id) {
		
		Hospitals theHospitals = hospitalDAO.saveSpeciality(theSpeciality, hospital_id);
		
		if(theHospitals.getHospitalDoctor().isEmpty()) {
			theHospitals.setHospitalDoctor(null);
		}
		
		if(theHospitals.getHospitalAddress().isEmpty()) {
			theHospitals.setHospitalAddress(null);
		}
		
		
		return theHospitals;
	}

	@Override
	@Transactional
	public Hospitals saveDoctor(HospitalDoctor theDoctor, int hospital_id) {
		
		Hospitals theHospital = hospitalDAO.saveDoctor(theDoctor, hospital_id);
		
		if(theHospital.getHospitalSpeciality().isEmpty()) {
			theHospital.setHospitalSpeciality(null);
		}
		
		if(theHospital.getHospitalAddress().isEmpty()) {
			theHospital.setHospitalAddress(null);
		}
		
		return theHospital;
	}

	@Override
	@Transactional
	public List<HospitalAddress> getAddresses(int hospital_id) {
		
		List<HospitalAddress> theList = hospitalDAO.getAddresses(hospital_id);
		
		return theList;
	}

	@Override
	@Transactional
	public List<HospitalSpeciality> getSpecialities(int hospital_id) {
		
		List<HospitalSpeciality> theList = hospitalDAO.getSpecialities(hospital_id);
		
		return theList;
	}

	@Override
	@Transactional
	public List<HospitalDoctor> getDoctors(int hospital_id, String speciality) {
		
		List<HospitalDoctor> theList = hospitalDAO.getDoctors(hospital_id, speciality);
		return theList;
	}

}
