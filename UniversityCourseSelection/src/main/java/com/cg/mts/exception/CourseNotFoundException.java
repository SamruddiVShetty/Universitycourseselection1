package com.cg.mts.exception;

public class CourseNotFoundException extends Exception {
	
	String message;
	public CourseNotFoundException(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return message;
	}

}
