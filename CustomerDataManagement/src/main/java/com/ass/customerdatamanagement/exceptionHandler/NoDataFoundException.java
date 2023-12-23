package com.ass.customerdatamanagement.exceptionHandler;

public class NoDataFoundException  extends RuntimeException{
	public String message="No data found for the given request";
	
	
	public NoDataFoundException() {
		
	}
	
	public NoDataFoundException(String message) {
		//super();
		this.message = message;
	}

	
//
//	@Override
//	public void printStackTrace() {we can't change the implementation of printstackTrace
//		super.printStackTrace();
//		
//	}
	public String getMessage() {
		return message;
		
	}

}
