package com.example.demo.controller;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionController {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		JSONObject result=new JSONObject();
		result.put("StatusCode", 0);
		result.put("Message", exception.getMessage());
		return new ResponseEntity<>(result.toJSONString(), HttpStatus.OK);		 
	}
}