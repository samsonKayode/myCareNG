package com.hypen.mycare.rest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hypen.mycare.entity.Profile;
import com.hypen.mycare.service.EmailService;
import com.hypen.mycare.service.ProfileService;
import com.hypen.mycare.success.SuccessEntity;
import com.hypen.mycare.utils.AeSimpleMD5;

@RestController
@RequestMapping("/rest")
public class ProfileRestController {

	@Autowired
	ProfileService profileService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//save profile..
	@PostMapping("/profiles")
	public SuccessEntity saveProfile(@RequestBody Profile theProfile) {
		
		SuccessEntity theSuccess;
		
		try {
			
			theProfile.setId(0);
			profileService.saveProfile(theProfile);
			
			theSuccess = new SuccessEntity(0, "User Data Inserted", System.currentTimeMillis());
			
		}catch(ConstraintViolationException cc) {
			
			theSuccess = new SuccessEntity(1, "User email already exist", System.currentTimeMillis());
			
		}
		catch(Exception cc) {
			
			theSuccess = new SuccessEntity(2, "Unable to save data "+cc.getMessage(), System.currentTimeMillis());
			
			System.out.println("THIS IS EXCEPTION CC======>>"+cc);
			
		}
			
		return theSuccess;
	}
	
	//verify user by email..
	
	@GetMapping("/profiles/{emailId}/{passwordId}")
	public SuccessEntity verifyEmail(@PathVariable String emailId, @PathVariable String passwordId) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		SuccessEntity theSuccess;
		
		String encodedPassword = AeSimpleMD5.MD5(passwordId);
		
		List<Profile> theProfile = profileService.checkEmail(emailId, encodedPassword);
		
		System.out.println("SIZE OF PROFILE =====>> "+theProfile.size());
		
		System.out.println("PASSWORD:=========>>>>>"+passwordId);
		
		
		if(theProfile.size()==0) {
			theSuccess = new SuccessEntity(0, "No user exist", System.currentTimeMillis());
			
		}else {
			Iterator<Profile> itr = theProfile.iterator();
			Profile pfs = (Profile) itr.next();
			String fname = pfs.getFirstName();
			String lname = pfs.getLastName();
			String email = pfs.getEmail();
			
			theSuccess = new SuccessEntity(pfs.getId(), fname +", "+lname+" # "+email, System.currentTimeMillis());
		}
		
		
		return theSuccess;
	}
	
	

}
