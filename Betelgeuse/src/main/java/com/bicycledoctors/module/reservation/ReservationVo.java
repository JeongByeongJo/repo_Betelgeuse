package com.bicycledoctors.module.reservation;

import com.bicycledoctors.common.base.BaseVo;

public class ReservationVo extends BaseVo {
	private String rsrvSeq;
	private String shop_shopSeq;
	private String bicycle_bikeSeq;
//	----
	public String getRsrvSeq() {
		return rsrvSeq;
	}
	public void setRsrvSeq(String rsrvSeq) {
		this.rsrvSeq = rsrvSeq;
	}
	public String getShop_shopSeq() {
		return shop_shopSeq;
	}
	public void setShop_shopSeq(String shop_shopSeq) {
		this.shop_shopSeq = shop_shopSeq;
	}
	public String getBicycle_bikeSeq() {
		return bicycle_bikeSeq;
	}
	public void setBicycle_bikeSeq(String bicycle_bikeSeq) {
		this.bicycle_bikeSeq = bicycle_bikeSeq;
	}
	
}
