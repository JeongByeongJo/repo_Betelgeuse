package com.bicycledoctors.module.reservation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bicycledoctors.module.shop.ShopAvailableServiceDto;

@Repository
public interface ReservationDao {
	public int insert(ReservationDto dto);
	public int bikeStatusUpdt(ReservationDto dto);
	public int rsrvServicesInst(@Param("listAS")List<ShopAvailableServiceDto> listAS);
	public ReservationDto selectOne4View(ReservationVo vo);
	
	public List<ReservationDto> selectList4ServiceView(ReservationVo vo);
}
