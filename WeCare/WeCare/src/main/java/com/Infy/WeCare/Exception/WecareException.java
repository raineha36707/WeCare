package com.Infy.WeCare.Exception;

public class WecareException extends Exception {

	private static final long serialVersionUID = 1L;

	public WecareException() {
		this("Something Went Wrong");
	}
	
	public WecareException(String message) {
		super(message);
	}
	
}
