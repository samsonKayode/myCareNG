package com.hypen.mycare.dao;

import java.util.List;

import com.hypen.mycare.entity.Profile;

public interface ProfileDAO {
	
	public List<Profile> checkEmail(String email, String password);
	
	public int saveProfile(Profile theProfile);

}
