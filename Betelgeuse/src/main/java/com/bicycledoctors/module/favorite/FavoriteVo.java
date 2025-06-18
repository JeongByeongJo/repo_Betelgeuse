package com.bicycledoctors.module.favorite;

import com.bicycledoctors.common.base.BaseVo;

public class FavoriteVo extends BaseVo {

	private String favrSeq;
	private String userCustomer_seq;
    private String shop_shopSeq;
    private String seq;
    private String shopSeq;
//	-----
	public String getFavrSeq() {
		return favrSeq;
	}
	public void setFavrSeq(String favrSeq) {
		this.favrSeq = favrSeq;
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
