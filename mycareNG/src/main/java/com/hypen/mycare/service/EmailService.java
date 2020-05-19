package com.hypen.mycare.service;

public interface EmailService {
	
	public int sendSimpleMessage(String to, String subject, String text);
	
	public void sendMessageWithAttachment(
		      String to, String subject, String text, String pathToAttachment);

}
