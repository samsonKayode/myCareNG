package com.hypen.mycare.junit;

import java.io.File;
import java.io.FileInputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hypen.mycare.entity.Hospitals;
import com.hypen.mycare.service.HospitalServiceImpl;

public class TestHospitals {
	
	@Autowired
	public static HospitalServiceImpl hospitalService;
	
	
    
    @Test
	public void testSaveHospital() {
		
		String imLoc = "/Users/kayode/Downloads/OH-Logo-3.jpeg";
		String hospitalName ="The Premier Specialists Medical Centre";
		String hospitalDesc = "Established in 1992, this hopsital is a woirld class "
				+ "medical facility with accreditations and accolades all around the world... more to come..";
		
		
		File file = new File(imLoc);
        byte[] hospitalLogo = new byte[(int) file.length()];
        
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(hospitalLogo);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        
        Hospitals theHospital = new Hospitals();
		
		//theHospital.setHospitalLogo(hospitalLogo);
		theHospital.setHospitalName(hospitalName);
		theHospital.setHospitalDesc(hospitalDesc);
		
		hospitalService.saveHospital(theHospital);
		
		//hospitalDAO.saveHospital(theHospital);
		
	}

}
