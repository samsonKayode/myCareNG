package com.hypen.mycare.exception;

import java.sql.SQLException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApplicationExceptions {
	

	@ExceptionHandler
	public ResponseEntity<ErrorEntity> handleException(Exception exc){
		
		ErrorEntity epo = new ErrorEntity();
		
		epo.setStatus(HttpStatus.BAD_REQUEST.value());
		epo.setTimeStamp(System.currentTimeMillis());
		epo.setMessage(exc.getMessage());
		
		
		return new ResponseEntity<>(epo, HttpStatus.BAD_REQUEST);
	}


	
	
	@ExceptionHandler
	public ResponseEntity<ErrorEntity> handleException(ProfileNotFoundException exc){
		
		ErrorEntity epo = new ErrorEntity();
		
		epo.setStatus(HttpStatus.NOT_FOUND.value());
		epo.setTimeStamp(System.currentTimeMillis());
		epo.setMessage(exc.getMessage());
		
		
		return new ResponseEntity<>(epo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorEntity> handleException(ProfileExistException exc){
		
		ErrorEntity epo = new ErrorEntity();
		
		epo.setStatus(HttpStatus.BAD_REQUEST.value());
		epo.setTimeStamp(System.currentTimeMillis());
		epo.setMessage(exc.getMessage());
		
		
		return new ResponseEntity<>(epo, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorEntity> handleException(DataIntegrityViolationException exc){
		
		ErrorEntity epo = new ErrorEntity();
		
		epo.setStatus(HttpStatus.BAD_REQUEST.value());
		epo.setTimeStamp(System.currentTimeMillis());
		epo.setMessage("Email already registered");
		
		
		return new ResponseEntity<>(epo, HttpStatus.BAD_REQUEST);
	}

}
