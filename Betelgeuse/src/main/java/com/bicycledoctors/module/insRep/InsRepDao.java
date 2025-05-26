package com.bicycledoctors.module.insRep;

import org.springframework.stereotype.Repository;

@Repository
public interface InsRepDao {

	public int insert(InsRepDto dto);
}
