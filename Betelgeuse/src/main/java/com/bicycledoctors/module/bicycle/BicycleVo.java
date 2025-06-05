package com.bicycledoctors.module.bicycle;

import com.bicycledoctors.common.base.BaseVo;

public class BicycleVo extends BaseVo{
	private String bikeSeq;
	private String userCustomer_seq;
	private String bikeStatus;
//	-----

	public String getBikeSeq() {
		return bikeSeq;
	}

	public void setBikeSeq(String bikeSeq) {
		this.bikeSeq = bikeSeq;
	}

	public String getUserCustomer_seq() {
		return userCustomer_seq;
	}

	public void setUserCustomer_seq(String userCustomer_seq) {
		this.userCustomer_seq = userCustomer_seq;
	}

	public String getBikeStatus() {
		return bikeStatus;
	}

	public void setBikeStatus(String bikeStatus) {
		this.bikeStatus = bikeStatus;
	}
	
}
