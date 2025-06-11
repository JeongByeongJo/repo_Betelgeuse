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
    private String shopName;
    private String userName;
    private String userId;
    private Integer star1Count;
    private Integer star2Count;
    private Integer star3Count;
    private Integer star4Count;
    private Integer star5Count;
    private Integer star1Rate;
    private Integer star2Rate;
    private Integer star3Rate;
    private Integer star4Rate;
    private Integer star5Rate;
    private Integer starsCount;
    private Double starsAvg;
    private Integer starsSum;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getStar1Count() {
		return star1Count != null ? star1Count : 0;
	}
	public void setStar1Count(Integer star1Count) {
		this.star1Count = star1Count;
	}
	public Integer getStar2Count() {
		return star2Count != null ? star2Count : 0;
	}
	public void setStar2Count(Integer star2Count) {
		this.star2Count = star2Count;
	}
	public Integer getStar3Count() {
		return star3Count != null ? star3Count : 0;
	}
	public void setStar3Count(Integer star3Count) {
		this.star3Count = star3Count;
	}
	public Integer getStar4Count() {
		return star4Count != null ? star4Count : 0;
	}
	public void setStar4Count(Integer star4Count) {
		this.star4Count = star4Count;
	}
	public Integer getStar5Count() {
		return star5Count != null ? star5Count : 0;
	}
	public void setStar5Count(Integer star5Count) {
		this.star5Count = star5Count;
	}
	public Integer getStarsCount() {
		starsCount = star1Count + star2Count + star3Count + star4Count + star5Count;
		return starsCount;
	}
	public void setStarsCount(Integer starsCount) {
		this.starsCount = starsCount;
	}
	public Integer getStar1Rate() {
		int total = getStarsCount();
	    return total == 0 ? 0 : (int) ((getStar1Count() / (double) total) * 100);
	}
	public void setStar1Rate(Integer star1Rate) {
		this.star1Rate = star1Rate;
	}
	public Integer getStar2Rate() {
		int total = getStarsCount();
	    return total == 0 ? 0 : (int) ((getStar2Count() / (double) total) * 100);
	}
	public void setStar2Rate(Integer star2Rate) {
		this.star2Rate = star2Rate;
	}
	public Integer getStar3Rate() {
		int total = getStarsCount();
	    return total == 0 ? 0 : (int) ((getStar3Count() / (double) total) * 100);
	}
	public void setStar3Rate(Integer star3Rate) {
		this.star3Rate = star3Rate;
	}
	public Integer getStar4Rate() {
		int total = getStarsCount();
	    return total == 0 ? 0 : (int) ((getStar4Count() / (double) total) * 100);
	}
	public void setStar4Rate(Integer star4Rate) {
		this.star4Rate = star4Rate;
	}
	public Integer getStar5Rate() {
		int total = getStarsCount();
	    return total == 0 ? 0 : (int) ((getStar5Count() / (double) total) * 100);
	}
	public void setStar5Rate(Integer star5Rate) {
		this.star5Rate = star5Rate;
	}
	public Double getStarsAvg() {
		int total = getStarsCount();
	    return total == 0 ? 0 : (getStarsSum() / (double) total);
	}
	public void setStarsAvg(Double starsAvg) {
		this.starsAvg = starsAvg;
	}
	public Integer getStarsSum() {
		return starsSum;
	}
	public void setStarsSum(Integer starsSum) {
		this.starsSum = starsSum;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
