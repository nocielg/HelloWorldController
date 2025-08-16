package com.in28minuts.rest.webservices.restfull_web_services.exception;

import java.time.LocalDate;

//import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minuts.rest.webservices.restfull_web_services.user.UserNotFoundException;

import jakarta.validation.constraints.Null;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/*@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleAllException(UserNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}*/
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected @Null ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

		
	}
	
	
}
