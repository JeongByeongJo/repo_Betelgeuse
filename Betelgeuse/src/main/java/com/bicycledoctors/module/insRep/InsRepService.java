package com.bicycledoctors.module.insRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsRepService {
	
	@Autowired
	InsRepDao dao;

	public int insert(InsRepDto dto) {
		return dao.insert(dto);
	}
}
