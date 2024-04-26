package com.gapsi.domain.exception;

public class ApplicationException extends Exception {
	
	private static final long serialVersionUID = -3853029100682263818L;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause); 
	}
	
	public ApplicationException(String message) {
		super(message); 
	}

}
