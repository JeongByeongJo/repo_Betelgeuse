package com.bicycledoctors.module.reservation;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicycledoctors.common.base.BaseService;
import com.bicycledoctors.module.shop.ShopAvailableServiceDto;

@Service
public class ReservationService extends BaseService {

	@Autowired
	ReservationDao dao;
	
	public int insert(ReservationVo vo) {
		dao.bikeStatusUpdt(vo);
		vo.setReservationDate(num2Date(vo.getReservationDateCd()).toString());
		return dao.insert(vo);
	}
	public int rsrvServicesInst(@Param("listAS")List<ShopAvailableServiceDto> listAS) {
		return dao.rsrvServicesInst(listAS);
	}
	
	public LocalDate num2Date(int i) {
		LocalDate today = LocalDate.now();
		LocalDate date = today.plusDays(i);
		return date;
	}
}
