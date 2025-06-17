package com.bicycledoctors.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

	@Autowired
	IndexDao dao;
	
	public IndexDto selectOneUserShopSeq(IndexVo vo) {
		return dao.selectOneUserShopSeq(vo);
	}

	
}
