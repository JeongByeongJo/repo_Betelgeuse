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
	
	public int insert(ReservationDto dto) {
		dao.bikeStatusUpdt(dto);
		dto.setReservationDate(num2Date(dto.getReservationDateCd()).toString());
		return dao.insert(dto);
	}
	public int rsrvServicesInst(@Param("listAS")List<ShopAvailableServiceDto> listAS) {
		return dao.rsrvServicesInst(listAS);
	}
	
	public ReservationDto selectOne4View(ReservationVo vo) {
		return dao.selectOne4View(vo);
	}
	
	public List<ReservationDto> selectList4ServiceView(ReservationVo vo) {
		return dao.selectList4ServiceView(vo);
	}
	
	public LocalDate num2Date(int i) {
		LocalDate today = LocalDate.now();
		LocalDate date = today.plusDays(i);
		return date;
	}
}
