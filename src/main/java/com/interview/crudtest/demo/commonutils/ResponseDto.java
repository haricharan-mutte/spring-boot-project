package com.interview.crudtest.demo.commonutils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDto implements Serializable {
	private static final long serialVersionUID = -8555557115768857726L;

	private int keyId;

	private String status;

	private List<ResponseCode> codes = new ArrayList<>();

	private HttpStatus httpStatusCode;

	public ResponseDto(int keyId, String status, HttpStatus httpStatusCode) {
		super();
		this.keyId = keyId;
		this.status = status;
		this.httpStatusCode = httpStatusCode;
	}

	public int getKeyId() {
		return keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ResponseCode> getCodes() {
		return codes;
	}

	public void setCodes(List<ResponseCode> codes) {
		this.codes = codes;
	}

	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(HttpStatus httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
}