package com.bicycledoctors.module.bicycle;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface BicycleDao {
	
	public List<BicycleDto> selectList(BicycleVo vo);
	public List<BicycleDto> selectOneList(BicycleDto dto);
	public BicycleDto selectOne(BicycleDto dto);
	public int selectOneCount(BicycleVo vo);
	public int insert(BicycleDto dto);
	public int update(BicycleDto dto);

}
