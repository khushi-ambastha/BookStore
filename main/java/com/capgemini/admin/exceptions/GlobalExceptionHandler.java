package com.capgemini.admin.exceptions;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(BookAlreadyExists.class)
	    public ResponseEntity<?> handleBookAlreadyExistsException(BookAlreadyExists ex, WebRequest request){
	    	ErrorDetails errorDetails = new ErrorDetails( new Date(), ex.getMessage(), request.getDescription(false));
	    	return new ResponseEntity<>(errorDetails.getMessage(), HttpStatus.CONFLICT);
	    }
	 @ExceptionHandler(SQLException.class)
		public ResponseEntity<?> SQLExcpetionHandler(SQLException ex, WebRequest request) {
			ErrorDetails errorDetails = new ErrorDetails( new Date(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errorDetails.getMessage(), HttpStatus.BAD_REQUEST);
		}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails( new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
