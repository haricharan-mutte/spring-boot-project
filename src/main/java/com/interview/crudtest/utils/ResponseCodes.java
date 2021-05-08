package com.interview.crudtest.utils;

public enum ResponseCodes {

	SUCCESS("Success"),
	
	FAILURE("Failure");
	
	String input;
	
	ResponseCodes(String input){
		this.input = input;
	}
}
