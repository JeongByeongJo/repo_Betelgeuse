package com.bicycledoctors.module.reservation;

import com.bicycledoctors.common.base.BaseVo;

public class ReservationVo extends BaseVo {
	private String rsrvSeq;
	private int reservationDateCd;
	private String reservationDate;
	private String reservationTime;
	private String shop_shopSeq;
	private String shopSeq;
	private String bicycle_bikeSeq;
	private String bikeSeq;
	private String rsrvDesc;
	private String userShopSeq;
	private String seq;
//	----
	public String getRsrvSeq() {
		return rsrvSeq;
	}
	public void setRsrvSeq(String rsrvSeq) {
		this.rsrvSeq = rsrvSeq;
	}
	public int getReservationDateCd() {
		return reservationDateCd;
	}
	public void setReservationDateCd(int reservationDateCd) {
		this.reservationDateCd = reservationDateCd;
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
	public String getShop_shopSeq() {
		return shop_shopSeq;
	}
	public void setShop_shopSeq(String shop_shopSeq) {
		this.shop_shopSeq = shop_shopSeq;
	}
	public String getShopSeq() {
		return shopSeq;
	}
	public void setShopSeq(String shopSeq) {
		this.shopSeq = shopSeq;
	}
	public String getBicycle_bikeSeq() {
		return bicycle_bikeSeq;
	}
	public void setBicycle_bikeSeq(String bicycle_bikeSeq) {
		this.bicycle_bikeSeq = bicycle_bikeSeq;
	}
	public String getBikeSeq() {
		return bikeSeq;
	}
	public void setBikeSeq(String bikeSeq) {
		this.bikeSeq = bikeSeq;
	}
	public String getRsrvDesc() {
		return rsrvDesc;
	}
	public void setRsrvDesc(String rsrvDesc) {
		this.rsrvDesc = rsrvDesc;
	}
	public String getUserShopSeq() {
		return userShopSeq;
	}
	public void setUserShopSeq(String userShopSeq) {
		this.userShopSeq = userShopSeq;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
}
