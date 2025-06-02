package com.bicycledoctors.module.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicycledoctors.common.base.BaseService;

@Service
public class ReviewService extends BaseService {
	
	@Autowired
	ReviewDao dao;
	
	public int insert(ReviewDto dto) {
		return dao.insert(dto);
	}

}
