package com.bicycledoctors.module.reservation;

import com.bicycledoctors.module.bicycle.BicycleDto;

public class ReservationDto extends BicycleDto {
	private String rsrvSeq;
	private int reservationDateCd;
	private String reservationDate;
	private String reservationTime;
	private String reservedNy;
	private String instDate;
	private String updtDate;
	private String shopSeq;
	private String shop_shopSeq;
	private String bikeSeq;
	private String bicycle_bikeSeq;
	private String rsrvDesc;
	private String availableServiceCd;
	private String userName;
	private String userTel;
	private Integer xCount;
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
	public String getRsrvDesc() {
		return rsrvDesc;
	}
	public void setRsrvDesc(String rsrvDesc) {
		this.rsrvDesc = rsrvDesc;
	}
	public int getReservationDateCd() {
		return reservationDateCd;
	}
	public void setReservationDateCd(int reservationDateCd) {
		this.reservationDateCd = reservationDateCd;
	}
	public String getBikeSeq() {
		return bikeSeq;
	}
	public void setBikeSeq(String bikeSeq) {
		this.bikeSeq = bikeSeq;
	}
	public String getShopSeq() {
		return shopSeq;
	}
	public void setShopSeq(String shopSeq) {
		this.shopSeq = shopSeq;
	}
	public String getAvailableServiceCd() {
		return availableServiceCd;
	}
	public void setAvailableServiceCd(String availableServiceCd) {
		this.availableServiceCd = availableServiceCd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public Integer getxCount() {
		return xCount;
	}
	public void setxCount(Integer xCount) {
		this.xCount = xCount;
	}
	
}
