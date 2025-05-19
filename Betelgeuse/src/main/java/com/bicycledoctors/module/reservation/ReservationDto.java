package com.bicycledoctors.module.reservation;

import com.bicycledoctors.common.base.BaseDto;

public class ReservationDto extends BaseDto{
	private String rsrvSeq;
	private String reservationDate;
	private String reservationTime;
	private String reservedNy;
	private String instDate;
	private String updtDate;
	private String shop_shopSeq;
	private String bicycle_bikeSeq;
//	-----
	public String getRsrvSeq() {
		return rsrvSeq;
	}
	public void setRsrvSeq(String rsrvSeq) {
		this.rsrvSeq = rsrvSeq;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getReservedNy() {
		return reservedNy;
	}
	public void setReservedNy(String reservedNy) {
		this.reservedNy = reservedNy;
	}
	public String getInstDate() {
		return instDate;
	}
	public void setInstDate(String instDate) {
		this.instDate = instDate;
	}
	public String getUpdtDate() {
		return updtDate;
	}
	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
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
