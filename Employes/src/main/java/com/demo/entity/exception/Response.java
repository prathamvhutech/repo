package com.demo.entity.exception;

public class Response 
{
	private String message;
	private int status;
	
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
