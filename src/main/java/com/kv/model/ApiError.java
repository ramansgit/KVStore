package com.kv.model;

import java.util.List;

public class ApiError {

	private String code;
	private String message;
	private String source;
	private List<ApiError> errors;
	
	public ApiError(String code, String message){
		
		this.code = code;
		this.message = message;
	}
	
	
	public List<ApiError> getErrors() {
		return errors;
	}
	public void setErrors(List<ApiError> errors) {
		this.errors = errors;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

}
