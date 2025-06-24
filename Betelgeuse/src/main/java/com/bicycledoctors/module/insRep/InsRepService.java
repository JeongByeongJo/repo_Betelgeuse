package com.bicycledoctors.module.insRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsRepService {
	
	@Autowired
	InsRepDao dao;

	public InsRepDto selectOne(InsRepVo vo) {
		return dao.selectOne(vo);
	}
	
	public int insert(InsRepDto dto) {
		return dao.insert(dto);
	}
	public int update(InsRepDto dto) {
		return dao.update(dto);
	}
	public int inrComplete(InsRepDto dto) {
		return dao.inrComplete(dto);
	}
	public int inrCompleteBike(InsRepDto dto) {
		return dao.inrCompleteBike(dto);
	}
	
}
