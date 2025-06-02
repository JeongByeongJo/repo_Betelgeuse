package com.bicycledoctors.module.review;

import com.bicycledoctors.common.base.BaseDto;

public class ReviewDto extends BaseDto {

	private String revwSeq;
    private String revwReviews;
    private String revwRate;
    private String revwDate;
    private String revwDelNy;
    private String revwUseNy;
    private String userCustomer_seq;
    private String shop_shopSeq;
//    -----
	public String getRevwSeq() {
		return revwSeq;
	}
	public void setRevwSeq(String revwSeq) {
		this.revwSeq = revwSeq;
	}
	public String getRevwReviews() {
		return revwReviews;
	}
	public void setRevwReviews(String revwReviews) {
		this.revwReviews = revwReviews;
	}
	public String getRevwRate() {
		return revwRate;
	}
	public void setRevwRate(String revwRate) {
		this.revwRate = revwRate;
	}
	public String getRevwDate() {
		return revwDate;
	}
	public void setRevwDate(String revwDate) {
		this.revwDate = revwDate;
	}
	public String getRevwDelNy() {
		return revwDelNy;
	}
	public void setRevwDelNy(String revwDelNy) {
		this.revwDelNy = revwDelNy;
	}
	public String getRevwUseNy() {
		return revwUseNy;
	}
	public void setRevwUseNy(String revwUseNy) {
		this.revwUseNy = revwUseNy;
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
    

}
