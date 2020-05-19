package com.hypen.mycare.dao;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class EmailServiceDAOImpl implements EmailServiceDAO {
	
    @Autowired
    public JavaMailSender javaMailSender;
    
    SimpleMailMessage message;

	@Override
	public int sendSimpleMessage(String to, String subject, String text) {
		int a =0;
		try {
			message = new SimpleMailMessage(); 
	        
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        javaMailSender.send(message);
	        
			a=1;
		}
		catch(Exception nn) {
			a=2;
		}
		
		return a;
		
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
		
		MimeMessage message = javaMailSender.createMimeMessage();

		try {
	          
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	         
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(text);
	        helper.setFrom("OxfordHealthPlus");
	             
	        FileSystemResource file 
	          = new FileSystemResource(new File(pathToAttachment));
	        helper.addAttachment(file.getFilename(), file);
	        
	        javaMailSender.send(message);
	        
	    	}
		
		catch(SendFailedException sfe) {
			System.out.println("SFE=========>>>>>"+sfe);
			
			sfe.printStackTrace();
		}
			
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//javaMailSender.send(message);
	}

}
