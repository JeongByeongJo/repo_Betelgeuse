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
	public int selectOneCount(BicycleVo vo) {
		return bicycleDao.selectOneCount(vo);
	}
	public int insert(BicycleDto dto) {
		return bicycleDao.insert(dto);
	}
	
}
