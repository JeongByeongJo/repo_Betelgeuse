package com.bicycledoctors.module.reservation;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bicycledoctors.module.shop.ShopAvailableServicesDto;

@Repository
public interface ReservationDao {
	public int insert(ReservationVo vo);
	public int insertAvailableServices(@Param("listAS")ShopAvailableServicesDto listAS);
}
