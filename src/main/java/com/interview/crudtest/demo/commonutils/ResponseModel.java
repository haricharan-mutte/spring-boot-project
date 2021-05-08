package com.interview.crudtest.demo.commonutils;

public class ResponseModel<T> {
	  private T data = null;
	  
	  public T getData() {
	    return this.data;
	  }
	  
	  public void setData(T data) {
	    this.data = data;
	  }
	}