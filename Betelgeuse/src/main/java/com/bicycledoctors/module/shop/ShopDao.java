package com.bicycledoctors.module.shop;

import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {

	public ShopDto selectOne4ShopLocation(ShopDto dto);
	public ShopDto selectOne4ShopLocation(ShopVo vo);
	
	public int insert(ShopDto dto);
	public int update(ShopDto dto);
}
