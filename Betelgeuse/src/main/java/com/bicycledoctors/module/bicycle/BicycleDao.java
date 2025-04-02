package com.bicycledoctors.module.bicycle;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface BicycleDao {
	
	public List<BicycleDto> selectList(BicycleVo vo);
	public int selectOneCount(BicycleVo vo);
	public int insert(BicycleDto dto);

}
