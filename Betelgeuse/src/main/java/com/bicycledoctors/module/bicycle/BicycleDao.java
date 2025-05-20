package com.bicycledoctors.module.bicycle;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bicycledoctors.common.base.BaseDao;
import com.bicycledoctors.common.base.BaseDto;


@Repository
public interface BicycleDao extends BaseDao{
	
	public List<BicycleDto> selectList(BicycleVo vo);
	public List<BicycleDto> selectOneList(BicycleVo vo);
	public List<BicycleDto> selectOneList(BicycleDto dto);
	public List<BicycleDto> selectOnePicList(BicycleDto dto);
	public BicycleDto selectOne(BicycleDto dto);
	public BicycleDto selectOne(BicycleVo vo);
	public int selectOneCount(BicycleVo vo);
	public int insert(BicycleDto dto);
	public int update(BicycleDto dto);
	public int updatePic(BicycleDto dto);
	public int insertUploaded(BaseDto dto);

}
