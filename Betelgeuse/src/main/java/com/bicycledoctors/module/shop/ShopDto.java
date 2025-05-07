package com.bicycledoctors.module.shop;

import java.util.List;

import com.bicycledoctors.common.base.BaseDto;

public class ShopDto extends BaseDto{
	private String seq;

	private String shopSeq;
    private String shopName;
    private String shopTel;
    private String shopEmail;
    private String shopZip;
    private String shopAddress1;
    private String shopAddress2;
    private String shopAddress3;
    private String shopAddress4;
    private Double shopLatitude;
    private Double shopLongitude;
    private String shopDescribe;
    private String parkingNy;
    private String wifiNy;
    private String cctvNy;
    private String cafeNy;
    private String petNy;
    private String customerFavoriteNy;
    private String mondayNy;
    private String tuesdayNy;
    private String wednesdayNy;
    private String thursdayNy;
    private String fridayNy;
    private String saturdayNy;
    private String sundayNy;
    private String mondayOpentime;
    private String mondayClosetime;
    private String tuesdayOpentime;
    private String tuesdayClosetime;
    private String wednesdayOpentime;
    private String wednesdayClosetime;
    private String thursdayOpentime;
    private String thurdayClosetime;
    private String fridayOpentime;
    private String fridayClosetime;
    private String saturdayOpentime;
    private String saturdayClosetime;
    private String sundayOpentime;
    private String sundayClosetime;
    private String verifiedNy;
    private String featuredNy;
    private Integer delNy;
    private String homepage;
    private String youtube;
    private String shopInstDate;
    private String shopUpdtDate;
    private String userCustomer_seq;
//    -----
    private Integer uploadImg1Type;
	private Integer uploadImg1MaxNumber;
    
	private List<BaseDto> picList;
	public List<BaseDto> getPicList() {
			return picList;
		}
	public void setPicList(List<BaseDto> picList) {
		this.picList = picList;
	}
	//    -----
	public String getShopSeq() {
		return shopSeq;
	}
	public void setShopSeq(String shopSeq) {
		this.shopSeq = shopSeq;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopTel() {
		return shopTel;
	}
	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}
	public String getShopEmail() {
		return shopEmail;
	}
	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}
	public String getShopZip() {
		return shopZip;
	}
	public void setShopZip(String shopZip) {
		this.shopZip = shopZip;
	}
	public String getShopAddress1() {
		return shopAddress1;
	}
	public void setShopAddress1(String shopAddress1) {
		this.shopAddress1 = shopAddress1;
	}
	public String getShopAddress2() {
		return shopAddress2;
	}
	public void setShopAddress2(String shopAddress2) {
		this.shopAddress2 = shopAddress2;
	}
	public String getShopAddress3() {
		return shopAddress3;
	}
	public void setShopAddress3(String shopAddress3) {
		this.shopAddress3 = shopAddress3;
	}
	public String getShopAddress4() {
		return shopAddress4;
	}
	public void setShopAddress4(String shopAddress4) {
		this.shopAddress4 = shopAddress4;
	}

	public Double getShopLatitude() {
		return shopLatitude;
	}
	public void setShopLatitude(Double shopLatitude) {
		this.shopLatitude = shopLatitude;
	}
	public Double getShopLongitude() {
		return shopLongitude;
	}
	public void setShopLongitude(Double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}
	public String getShopDescribe() {
		return shopDescribe;
	}
	public void setShopDescribe(String shopDescribe) {
		this.shopDescribe = shopDescribe;
	}
	public String getParkingNy() {
		return parkingNy;
	}
	public void setParkingNy(String parkingNy) {
		this.parkingNy = parkingNy;
	}
	public String getWifiNy() {
		return wifiNy;
	}
	public void setWifiNy(String wifiNy) {
		this.wifiNy = wifiNy;
	}
	public String getCctvNy() {
		return cctvNy;
	}
	public void setCctvNy(String cctvNy) {
		this.cctvNy = cctvNy;
	}
	public String getCafeNy() {
		return cafeNy;
	}
	public void setCafeNy(String cafeNy) {
		this.cafeNy = cafeNy;
	}
	public String getPetNy() {
		return petNy;
	}
	public void setPetNy(String petNy) {
		this.petNy = petNy;
	}
	public String getCustomerFavoriteNy() {
		return customerFavoriteNy;
	}
	public void setCustomerFavoriteNy(String customerFavoriteNy) {
		this.customerFavoriteNy = customerFavoriteNy;
	}
	public String getMondayNy() {
		return mondayNy;
	}
	public void setMondayNy(String mondayNy) {
		this.mondayNy = mondayNy;
	}
	public String getTuesdayNy() {
		return tuesdayNy;
	}
	public void setTuesdayNy(String tuesdayNy) {
		this.tuesdayNy = tuesdayNy;
	}
	public String getWednesdayNy() {
		return wednesdayNy;
	}
	public void setWednesdayNy(String wednesdayNy) {
		this.wednesdayNy = wednesdayNy;
	}
	public String getThursdayNy() {
		return thursdayNy;
	}
	public void setThursdayNy(String thursdayNy) {
		this.thursdayNy = thursdayNy;
	}
	public String getFridayNy() {
		return fridayNy;
	}
	public void setFridayNy(String fridayNy) {
		this.fridayNy = fridayNy;
	}
	public String getSaturdayNy() {
		return saturdayNy;
	}
	public void setSaturdayNy(String saturdayNy) {
		this.saturdayNy = saturdayNy;
	}
	public String getSundayNy() {
		return sundayNy;
	}
	public void setSundayNy(String sundayNy) {
		this.sundayNy = sundayNy;
	}
	public String getMondayOpentime() {
		return mondayOpentime;
	}
	public void setMondayOpentime(String mondayOpentime) {
		this.mondayOpentime = mondayOpentime;
	}
	public String getMondayClosetime() {
		return mondayClosetime;
	}
	public void setMondayClosetime(String mondayClosetime) {
		this.mondayClosetime = mondayClosetime;
	}
	public String getTuesdayOpentime() {
		return tuesdayOpentime;
	}
	public void setTuesdayOpentime(String tuesdayOpentime) {
		this.tuesdayOpentime = tuesdayOpentime;
	}
	public String getTuesdayClosetime() {
		return tuesdayClosetime;
	}
	public void setTuesdayClosetime(String tuesdayClosetime) {
		this.tuesdayClosetime = tuesdayClosetime;
	}
	public String getWednesdayOpentime() {
		return wednesdayOpentime;
	}
	public void setWednesdayOpentime(String wednesdayOpentime) {
		this.wednesdayOpentime = wednesdayOpentime;
	}
	public String getWednesdayClosetime() {
		return wednesdayClosetime;
	}
	public void setWednesdayClosetime(String wednesdayClosetime) {
		this.wednesdayClosetime = wednesdayClosetime;
	}
	public String getThursdayOpentime() {
		return thursdayOpentime;
	}
	public void setThursdayOpentime(String thursdayOpentime) {
		this.thursdayOpentime = thursdayOpentime;
	}
	public String getThurdayClosetime() {
		return thurdayClosetime;
	}
	public void setThurdayClosetime(String thurdayClosetime) {
		this.thurdayClosetime = thurdayClosetime;
	}
	public String getFridayOpentime() {
		return fridayOpentime;
	}
	public void setFridayOpentime(String fridayOpentime) {
		this.fridayOpentime = fridayOpentime;
	}
	public String getFridayClosetime() {
		return fridayClosetime;
	}
	public void setFridayClosetime(String fridayClosetime) {
		this.fridayClosetime = fridayClosetime;
	}
	public String getSaturdayOpentime() {
		return saturdayOpentime;
	}
	public void setSaturdayOpentime(String saturdayOpentime) {
		this.saturdayOpentime = saturdayOpentime;
	}
	public String getSaturdayClosetime() {
		return saturdayClosetime;
	}
	public void setSaturdayClosetime(String saturdayClosetime) {
		this.saturdayClosetime = saturdayClosetime;
	}
	public String getSundayOpentime() {
		return sundayOpentime;
	}
	public void setSundayOpentime(String sundayOpentime) {
		this.sundayOpentime = sundayOpentime;
	}
	public String getSundayClosetime() {
		return sundayClosetime;
	}
	public void setSundayClosetime(String sundayClosetime) {
		this.sundayClosetime = sundayClosetime;
	}
	public String getVerifiedNy() {
		return verifiedNy;
	}
	public void setVerifiedNy(String verifiedNy) {
		this.verifiedNy = verifiedNy;
	}
	public String getFeaturedNy() {
		return featuredNy;
	}
	public void setFeaturedNy(String featuredNy) {
		this.featuredNy = featuredNy;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getShopInstDate() {
		return shopInstDate;
	}
	public void setShopInstDate(String shopInstDate) {
		this.shopInstDate = shopInstDate;
	}
	public String getShopUpdtDate() {
		return shopUpdtDate;
	}
	public void setShopUpdtDate(String shopUpdtDate) {
		this.shopUpdtDate = shopUpdtDate;
	}
	public String getUserCustomer_seq() {
		return userCustomer_seq;
	}
	public void setUserCustomer_seq(String userCustomer_seq) {
		this.userCustomer_seq = userCustomer_seq;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Integer getUploadImg1Type() {
		return uploadImg1Type;
	}
	public void setUploadImg1Type(Integer uploadImg1Type) {
		this.uploadImg1Type = uploadImg1Type;
	}
	public Integer getUploadImg1MaxNumber() {
		return uploadImg1MaxNumber;
	}
	public void setUploadImg1MaxNumber(Integer uploadImg1MaxNumber) {
		this.uploadImg1MaxNumber = uploadImg1MaxNumber;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
    
	
}
