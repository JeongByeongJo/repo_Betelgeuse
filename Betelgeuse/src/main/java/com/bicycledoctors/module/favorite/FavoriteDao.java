package com.bicycledoctors.module.favorite;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDao {
	
	public List<FavoriteDto> selectList(FavoriteVo vo);
	public FavoriteDto selectOne(FavoriteVo vo);
	public int selectOneCount(FavoriteVo vo);
	public int selectOneCount4Shop(FavoriteVo vo);
	public int insert(FavoriteDto dto);
	public int insert(FavoriteVo vo);
	public int uelete(FavoriteDto dto);
	public int ueleteAll(FavoriteDto dto);
	public int update(FavoriteDto dto);

}
