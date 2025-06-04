package com.bicycledoctors.module.review;

import com.bicycledoctors.common.base.BaseVo;

public class ReviewVo extends BaseVo{

	private String revwSeq;
	private String userCustomer_seq;
	private String shop_shopSeq;
	private String seq;
	private String shopSeq;
//	-----
	public String getRevwSeq() {
		return revwSeq;
	}
	public void setRevwSeq(String revwSeq) {
		this.revwSeq = revwSeq;
	}
	public String getUserCustomer_seq() {
		return userCustomer_seq;
	}
	public void setUserCustomer_seq(String userCustomer_seq) {
		this.userCustomer_seq = userCustomer_seq;
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
	public String getShopSeq() {
		return shopSeq;
	}
	public void setShopSeq(String shopSeq) {
		this.shopSeq = shopSeq;
	}
	
}
