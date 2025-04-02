package com.bicycledoctors.module.member;

import com.bicycledoctors.common.base.BaseVo;

public class MemberVo extends BaseVo{
	
	private String seq;
	
	private Integer shBlackNy = 0;
//	-----

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Integer getShBlackNy() {
		return shBlackNy;
	}

	public void setShBlackNy(Integer shBlackNy) {
		this.shBlackNy = shBlackNy;
	}

	
}
