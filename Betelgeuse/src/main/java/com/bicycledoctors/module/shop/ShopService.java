package com.bicycledoctors.module.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

	@Autowired
	ShopDao dao;
	
	public ShopDto selectOne4ShopLocation(ShopDto dto) {
		return dao.selectOne4ShopLocation(dto);
	}
	public ShopDto selectOne4ShopLocation(ShopVo vo) {
		return dao.selectOne4ShopLocation(vo);
	}
	
	public int insert(ShopDto dto) {
		return dao.insert(dto);
	}

	public int update(ShopDto dto) {
		return dao.update(dto);
	}
}
