package com.hypen.mycare.service;

import java.util.List;

import com.hypen.mycare.entity.Profile;

public interface ProfileService {
	
	public List<Profile> checkEmail(String email, String Password);

	public int saveProfile(Profile theProfile);
	
}
