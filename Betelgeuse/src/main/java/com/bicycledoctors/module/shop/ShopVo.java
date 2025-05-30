package com.bicycledoctors.module.shop;

import java.util.List;

import com.bicycledoctors.common.base.BaseVo;

public class ShopVo extends BaseVo{

	private String seq;
	private String shopSeq;
    private String userCustomer_seq;
    private List<String> shopSeqList;
//-----
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
	public String getUserCustomer_seq() {
		return userCustomer_seq;
	}
	public void setUserCustomer_seq(String userCustomer_seq) {
		this.userCustomer_seq = userCustomer_seq;
	}
	public List<String> getShopSeqList() {
		return shopSeqList;
	}
	public void setShopSeqList(List<String> shopSeqList) {
		this.shopSeqList = shopSeqList;
	}
    
}
