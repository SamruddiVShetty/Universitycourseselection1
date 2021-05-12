package com.cg.mts.exception;

public class AdmissionNotGrantedException extends Exception {

	String message;
	public AdmissionNotGrantedException(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return message;
	}
}
