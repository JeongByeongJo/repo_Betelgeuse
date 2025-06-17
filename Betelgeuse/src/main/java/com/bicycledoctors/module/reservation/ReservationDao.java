package com.bicycledoctors.module.reservation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bicycledoctors.module.shop.ShopAvailableServiceDto;

@Repository
public interface ReservationDao {
	public int insert(ReservationDto dto);
	public int rsrvUpdt(ReservationDto dto);
	public int rsrvYesUpdt(ReservationDto dto);
	public int rsrvNoUpdt(ReservationDto dto);
	public int bikeStatusUpdt(ReservationDto dto);
	public Integer selectOneCountRsrvList(ReservationVo vo);
	public Integer selectOneCountInRList(ReservationVo vo);
	public int rsrvServicesInst(@Param("listAS")List<ShopAvailableServiceDto> listAS);
	public ReservationDto selectOne4View(ReservationVo vo);
	
	public ReservationDto selectOne(ReservationVo vo);
	public int selectOneCount(ReservationVo vo);
	public List<ReservationDto> selectList(ReservationVo vo);
	public List<ReservationDto> selectList4ServiceView(ReservationVo vo);
	public List<ReservationDto> selectList4ReservationCheck(ReservationVo vo);
	public List<ReservationDto> selectList4iNr(ReservationVo vo);
}
