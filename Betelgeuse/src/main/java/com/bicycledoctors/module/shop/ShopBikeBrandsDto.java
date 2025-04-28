package com.bicycledoctors.module.shop;

import java.util.List;

public class ShopBikeBrandsDto {
	
	private List<Integer> bikeBrandCd;
	private String shop_shopSeq;
	private String shopSeq;
//	-----
	public List<Integer> getBikeBrandCd() {
		return bikeBrandCd;
	}
	public void setBikeBrandCd(List<Integer> bikeBrandCd) {
		this.bikeBrandCd = bikeBrandCd;
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

}
