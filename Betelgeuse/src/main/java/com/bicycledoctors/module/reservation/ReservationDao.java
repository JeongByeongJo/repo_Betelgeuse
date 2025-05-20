package com.bicycledoctors.module.reservation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bicycledoctors.module.shop.ShopAvailableServiceDto;
import com.bicycledoctors.module.shop.ShopAvailableServicesDto;

@Repository
public interface ReservationDao {
	public int insert(ReservationVo vo);
	public int bikeStatusUpdt(ReservationVo vo);
	public int rsrvServicesInst(@Param("listAS")List<ShopAvailableServiceDto> listAS);
}
