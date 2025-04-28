package com.bicycledoctors.module.shop;

import java.util.List;

public class ShopAvailableServicesDto {

	private List<Integer> availableServiceCd;
	private String shopSeq;
	private String shop_shopSeq;
	private String seq;
//	-----
	public List<Integer> getAvailableServiceCd() {
		return availableServiceCd;
	}
	public void setAvailableServiceCd(List<Integer> availableServiceCd) {
		this.availableServiceCd = availableServiceCd;
	}
	public String getShopSeq() {
		return shopSeq;
	}
	public void setShopSeq(String shopSeq) {
		this.shopSeq = shopSeq;
	}
	public String getShop_shopSeq() {
		return shop_shopSeq;
	}
	public void setShop_shopSeq(String shop_shopSeq) {
		this.shop_shopSeq = shop_shopSeq;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
}
