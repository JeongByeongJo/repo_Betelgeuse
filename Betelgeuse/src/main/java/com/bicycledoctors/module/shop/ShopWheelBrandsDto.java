package com.bicycledoctors.module.shop;

import java.util.List;

public class ShopWheelBrandsDto {
	
	private List<Integer> wheelBrandCd;
	private String shop_shopSeq;
	private String shopSeq;
//	-----
	public String getShop_shopSeq() {
		return shop_shopSeq;
	}
	public List<Integer> getWheelBrandCd() {
		return wheelBrandCd;
	}
	public void setWheelBrandCd(List<Integer> wheelBrandCd) {
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

}
