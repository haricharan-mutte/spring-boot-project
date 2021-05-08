package com.interview.crudtest.demo.commonutils;

public class ResponseDtoWrapper {
	  private ResponseDto messages;
	  
	  private ResponseResource data;
	  
	  public ResponseDto getMessages() {
	    return this.messages;
	  }
	  
	  public void setMessages(ResponseDto messages) {
	    this.messages = messages;
	  }
	  
	  public ResponseResource getData() {
	    return this.data;
	  }
	  
	  public void setData(ResponseResource data) {
	    this.data = data;
	  }
}
