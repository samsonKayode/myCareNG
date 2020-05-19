package com.hypen.mycare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hypen.mycare.dao.EmailServiceDAO;

@Service
public class EmailServiceImpl implements EmailService  {
  
    @Autowired
    EmailServiceDAO emailServiceDAO;
    
	@Override
	public int sendSimpleMessage(String to, String subject, String text) {
		// TODO Auto-generated method stub
		
		int a  = emailServiceDAO.sendSimpleMessage(to, subject, text);
		
		return a;
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
		// TODO Auto-generated method stub
		
		emailServiceDAO.sendMessageWithAttachment(to, subject, text, pathToAttachment);
	}
    
}