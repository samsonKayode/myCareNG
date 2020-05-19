package com.hypen.mycare.dao;

import java.util.List;

import com.hypen.mycare.entity.HospitalAddress;
import com.hypen.mycare.entity.HospitalDoctor;
import com.hypen.mycare.entity.HospitalSpeciality;
import com.hypen.mycare.entity.Hospitals;

public interface HospitalDAO {

	public Hospitals saveHospital(Hospitals theHospital);
	
	public Hospitals saveHospitalAddress(HospitalAddress theAddress, int hospitalID);
	
	public Hospitals getSingle(int hospital_id);
	
	public List<Hospitals> getHospitalList();
	
	public Hospitals saveSpeciality(HospitalSpeciality theSpeciality, int hospital_id);
	
	public Hospitals saveDoctor(HospitalDoctor theDoctor, int hospital_id);
	
	public List<HospitalAddress> getAddresses(int hospital_id);
	
	public List<HospitalSpeciality> getSpecialities(int hospital_id);
	
	public List<HospitalDoctor> getDoctors(int hospital_id, String speciality);
	
}
