package com.bicycledoctors.module.review;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao {
	
	public int insert(ReviewDto dto);
	public int update(ReviewDto dto);
	public int uelete(ReviewDto dto);
	public int selectOneCount(ReviewVo vo);
	public List<ReviewDto> selectList4Shop(ReviewVo vo);
	public ReviewDto selectCount4Reviews(ReviewVo vo);
	public ReviewDto selectOne(ReviewVo vo);
	public List<ReviewDto> selectList(ReviewVo vo);

}
