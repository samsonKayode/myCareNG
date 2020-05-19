package com.hypen.mycare.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hypen.mycare.dao.EmailServiceDAO;
import com.hypen.mycare.dao.ProfileDAO;
import com.hypen.mycare.entity.Profile;
import com.hypen.mycare.utils.AeSimpleMD5;
import com.hypen.mycare.utils.SessionGenerator;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	ProfileDAO profileDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	EmailServiceDAO emailServiceDAO;
	
	AeSimpleMD5 md5;


	@Override
	@Transactional
	public int saveProfile(Profile theProfile) {
		
		int a;
		
		String myID = SessionGenerator.nextSessionId().toUpperCase();
		
		String subject="Welcome to OxfordHealthPlus";
		String text = "Thank you for registering with us at OxfordHealthPlus. Your code is "+myID;
		
		//String pathToAttachment = "/mycareNG/src/main/resources/Patient right and responsibilities.pdf";
		String pathToAttachment="/Users/kayode/Downloads/Patient_right_and_responsibilities.pdf";
		//String pathToAttachment ="/Users/kayode/Downloads/HD-LOGO.png";
		
		Profile profile = new Profile();
		
		profile.setCity(theProfile.getCity());
		profile.setDob(theProfile.getDob());
		profile.setEmail(theProfile.getEmail());
		profile.setFirstName(theProfile.getFirstName());
		profile.setId(theProfile.getId());
		profile.setLastName(theProfile.getLastName());
		profile.setPasskey(theProfile.getPasskey());
		profile.setPhone(theProfile.getPhone());
		profile.setSex(theProfile.getSex());
		profile.setState(theProfile.getState());
		profile.setPatient_id(myID);
		profile.setIMG(theProfile.getIMG());
		try {
			profile.setPassword(AeSimpleMD5.MD5(theProfile.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Save profile..
		
		a = profileDAO.saveProfile(profile);
		
		//Send Email..
		
		if(a==1) {
			
			Thread thread = new Thread(){
			    public void run(){
			    	emailServiceDAO.sendMessageWithAttachment(theProfile.getEmail(), subject, text, pathToAttachment);
			    }
			  };

			  thread.start();
			
		}else {
			
		}
		
		return a;

	}


	@Override
	@Transactional
	public List<Profile> checkEmail(String email, String password) {
	
		List<Profile> theProfile = profileDAO.checkEmail(email, password);
		
		return theProfile;
	}
	

}
