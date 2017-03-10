package com.newt.exception;

public class InvoiceException extends Exception{

	private String errorCode;
	
	public InvoiceException(String errorCode, String message) {
		super(errorCode);
		this.errorCode=errorCode;
	}
	
	public String getErrCode(){
		return this.errorCode;
	}

}
