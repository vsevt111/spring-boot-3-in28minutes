package com.manin.in28minutes.rest.webservice.socialrestwebservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.manin.in28minutes.rest.webservice.socialrestwebservice.ErrorDetail;
import com.manin.in28minutes.rest.webservice.socialrestwebservice.user.UserNotFoundException;

@ControllerAdvice
public class CustomerizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetail> handleAllException(Exception ex,WebRequest request){
		ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetail>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetail> handleAllUserException(Exception ex,WebRequest request){
		ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetail>(errorDetail,HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetail,HttpStatus.BAD_REQUEST);
	}

}
