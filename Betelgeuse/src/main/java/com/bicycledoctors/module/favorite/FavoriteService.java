package com.bicycledoctors.module.favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
	
	@Autowired
	FavoriteDao dao;
	
	public List<FavoriteDto> selectList(FavoriteVo vo) {
		return dao.selectList(vo);
	}
	public FavoriteDto selectOne(FavoriteVo vo) {
		return dao.selectOne(vo);
	}
	public int selectOneCount(FavoriteVo vo) {
		return dao.selectOneCount(vo);
	}
	public int selectOneCount4Shop(FavoriteVo vo) {
		return dao.selectOneCount4Shop(vo);
	}
	public int insert(FavoriteDto dto) {
		return dao.insert(dto);
	}
	public int uelete(FavoriteDto dto) {
		return dao.uelete(dto);
	}
	public int update(FavoriteDto dto) {
		return dao.update(dto);
	}

}
