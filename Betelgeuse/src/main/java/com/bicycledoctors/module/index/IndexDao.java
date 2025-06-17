package com.bicycledoctors.module.index;

import org.springframework.stereotype.Repository;

@Repository
public interface IndexDao {
	
	public IndexDto selectOneUserShopSeq(IndexVo vo);

}
