package com.mioto.sandbox.jerseyboot.vo;

public class Health {

	private String status;

	public Health(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
