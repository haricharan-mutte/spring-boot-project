package com.interview.crudtest.demo.commonutils;

public class ResponseCode {

	private String Code;

	private String Desc;

	public ResponseCode() {
	}

	public ResponseCode(String code) {
		this.Code = code;
	}

	public String getCode() {
		return this.Code;
	}

	public void setCode(String code) {
		this.Code = code;
	}

	public String getDesc() {
		return this.Desc;
	}

	public void setDesc(String desc) {
		this.Desc = desc;
	}
}
