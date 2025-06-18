package com.bicycledoctors.module.favorite;

import com.bicycledoctors.common.base.BaseDto;

public class FavoriteDto extends BaseDto{

	private String favrSeq;
	private String userCustomer_seq;
	private Integer favrDelNy;
    private Integer favrUseNy;
    private String shop_shopSeq;
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
	public Integer getFavrDelNy() {
		return favrDelNy;
	}
	public void setFavrDelNy(Integer favrDelNy) {
		this.favrDelNy = favrDelNy;
	}
	public Integer getFavrUseNy() {
		return favrUseNy;
	}
	public void setFavrUseNy(Integer favrUseNy) {
		this.favrUseNy = favrUseNy;
	}
	public String getShop_shopSeq() {
		return shop_shopSeq;
	}
	public void setShop_shopSeq(String shop_shopSeq) {
		this.shop_shopSeq = shop_shopSeq;
	}
	
    
}
