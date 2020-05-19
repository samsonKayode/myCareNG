package com.hypen.mycare.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hypen.mycare.entity.HospitalAddress;
import com.hypen.mycare.entity.HospitalDoctor;
import com.hypen.mycare.entity.HospitalSpeciality;
import com.hypen.mycare.entity.Hospitals;
import com.hypen.mycare.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalRestController {
	
	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/lists")
	public List<Hospitals> getHospitals(){
		
		List<Hospitals> theList = hospitalService.getHospitalList();
		
		return theList;
	}
	
	//Save Hospital
	@PostMapping("/lists")
	public Hospitals saveHospital(@RequestBody Hospitals theHospital) {
		 
		hospitalService.saveHospital(theHospital);
		
		return theHospital;
	}
	
	
	//Save Hospital Address
	@PostMapping("/lists/address/{hospital_id}")
	public Hospitals saveAddress(@RequestBody HospitalAddress theAddress,  @PathVariable int hospital_id) {
		
		Hospitals theAdd = hospitalService.saveHospitalAddress(theAddress, hospital_id);
		
		return theAdd;
	}
	
	@GetMapping("/lists/{hospital_id}")
	public Hospitals getSingleHospital(@PathVariable int hospital_id) {
		
		Hospitals theHospital = hospitalService.getSingle(hospital_id);
		
		return theHospital;
	}
	
	
	//Save Specialities

	
	@PostMapping("/lists/specialities/{hospital_id}")
	public Hospitals saveSpeciality(@RequestBody HospitalSpeciality theSpeciality, @PathVariable int hospital_id) {
		
		Hospitals theHospital = hospitalService.saveSpeciality(theSpeciality, hospital_id);
		
		theHospital.setHospitalAddress(null);
		
		return theHospital;
	}
	
	//Save Doctor..
	
	@PostMapping("/lists/doctors/{hospital_id}")
	public Hospitals saveDoctor(@RequestBody HospitalDoctor theDoctor, @PathVariable int hospital_id) {
		
		Hospitals theHospital = hospitalService.saveDoctor(theDoctor, hospital_id);
		
		theHospital.setHospitalAddress(null);
		theHospital.setHospitalSpeciality(null);
		
		return theHospital;
	}
	
	//get hospital addresses..
	
	@GetMapping("/lists/address/{hospital_id}")
	public List<HospitalAddress> getAddresses(@PathVariable("hospital_id") int hospital_id){
		
		List<HospitalAddress> theList = hospitalService.getAddresses(hospital_id);
		
		return theList;
	}
	
	//get Hospital Specialities..
	
	@GetMapping("/lists/specs/{hospital_id}")
	public List<HospitalSpeciality> getSpecialities(@PathVariable("hospital_id") int hospital_id){
		
		List<HospitalSpeciality> theList = hospitalService.getSpecialities(hospital_id);
		
		return theList;
	}
	
	//get doctors..
	
	@GetMapping("/lists/docs/{hospital_id}/{speciality}")
	public List<HospitalDoctor> getDoctors(@PathVariable("hospital_id") int hospital_id, 
			@PathVariable("speciality") String speciality){
		
		List<HospitalDoctor> theList = hospitalService.getDoctors(hospital_id, speciality);
		
		return theList;
	}

}
