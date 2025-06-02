package com.bicycledoctors.module.review;

import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao {
	
	public int insert(ReviewDto dto);

}
