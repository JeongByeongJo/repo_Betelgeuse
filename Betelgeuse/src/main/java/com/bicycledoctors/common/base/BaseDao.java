package com.bicycledoctors.common.base;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao {
	
	public int insertUploaded(BaseDto dto);

}
