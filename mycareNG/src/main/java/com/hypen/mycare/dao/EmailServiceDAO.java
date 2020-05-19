package com.hypen.mycare.dao;

public interface EmailServiceDAO {
	
	public int sendSimpleMessage(String to, String subject, String text);
	
	public void sendMessageWithAttachment(
		      String to, String subject, String text, String pathToAttachment);

}
