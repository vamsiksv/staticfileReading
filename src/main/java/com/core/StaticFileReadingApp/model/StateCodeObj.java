package com.core.StaticFileReadingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StateCodeObj {
	
	@Id
	private String stateCode;
	
	private String indicator;

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public StateCodeObj(String stateCode, String indicator) {
		super();
		this.stateCode = stateCode;
		this.indicator = indicator;
	}

	@Override
	public String toString() {
		return "StateCodeObj [stateCode=" + stateCode + ", indicator=" + indicator + "]";
	}
	
	

}
