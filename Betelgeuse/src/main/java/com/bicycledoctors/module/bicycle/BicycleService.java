package com.bicycledoctors.module.bicycle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BicycleService {
	
	@Autowired
	BicycleDao bicycleDao;

	public List<BicycleDto> selectList(BicycleVo vo) {
		return bicycleDao.selectList(vo);
	}
	public List<BicycleDto> selectOneList(BicycleDto dto) {
		return bicycleDao.selectOneList(dto);
	}
	public BicycleDto selectOne(BicycleDto dto) {
		return bicycleDao.selectOne(dto);
	}
	
	public int selectOneCount(BicycleVo vo) {
		return bicycleDao.selectOneCount(vo);
	}
	public int insert(BicycleDto dto) {
		return bicycleDao.insert(dto);
	}
	public int update(BicycleDto dto) {
		return bicycleDao.update(dto);
	}
	
}
