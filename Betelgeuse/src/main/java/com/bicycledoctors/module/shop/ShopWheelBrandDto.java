package com.bicycledoctors.module.shop;

public class ShopWheelBrandDto {
	
	private Integer wheelBrandCd;
	private String shop_shopSeq;
	private String shopSeq;
	private String userShopSeq;
	
	private String seq;
	
	private String cdSeq;
	private String cdName;
	private String cdNameEng;
	private String codegroup_cdgSeq;

//	-----
	public String getShop_shopSeq() {
		return shop_shopSeq;
	}
	public Integer getWheelBrandCd() {
		return wheelBrandCd;
	}
	public void setWheelBrandCd(Integer wheelBrandCd) {
		this.wheelBrandCd = wheelBrandCd;
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
	public String getCdSeq() {
		return cdSeq;
	}
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public String getCdNameEng() {
		return cdNameEng;
	}
	public void setCdNameEng(String cdNameEng) {
		this.cdNameEng = cdNameEng;
	}
	public String getCodegroup_cdgSeq() {
		return codegroup_cdgSeq;
	}
	public void setCodegroup_cdgSeq(String codegroup_cdgSeq) {
		this.codegroup_cdgSeq = codegroup_cdgSeq;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getUserShopSeq() {
		return userShopSeq;
	}
	public void setUserShopSeq(String userShopSeq) {
		this.userShopSeq = userShopSeq;
	}

}
