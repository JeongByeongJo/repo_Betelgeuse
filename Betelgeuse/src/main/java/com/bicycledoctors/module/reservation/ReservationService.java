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
	
	public List<ReservationDto> selectList(ReservationVo vo) {
		return dao.selectList(vo);
	}
	public int selectOneCount(ReservationVo vo) {
		return dao.selectOneCount(vo);
	}
	public ReservationDto selectOne(ReservationVo vo) {
		return dao.selectOne(vo);
	}
	public int insert(ReservationDto dto) {
		dao.bikeStatusUpdt(dto);
		dto.setReservationDate(num2Date(dto.getReservationDateCd()).toString());
		return dao.insert(dto);
	}
	public int rsrvServicesInst(@Param("listAS")List<ShopAvailableServiceDto> listAS) {
		return dao.rsrvServicesInst(listAS);
	}
	public int rsrvUpdt(ReservationDto dto) {
		return dao.rsrvUpdt(dto);
	}
	public int rsrvYesUpdt(ReservationDto dto) {
		return dao.rsrvYesUpdt(dto);
	}
	public int rsrvNoUpdt(ReservationDto dto) {
		return dao.rsrvNoUpdt(dto);
	}
	
	public ReservationDto selectOne4View(ReservationVo vo) {
		return dao.selectOne4View(vo);
	}
	
	public List<ReservationDto> selectList4ServiceView(ReservationVo vo) {
		return dao.selectList4ServiceView(vo);
	}
	
	public List<ReservationDto> selectList4ReservationCheck(ReservationVo vo) {
		return dao.selectList4ReservationCheck(vo);
	}
	public List<ReservationDto> selectList4iNr(ReservationVo vo) {
		return dao.selectList4iNr(vo);
	}
	
	
	public LocalDate num2Date(int i) {
		LocalDate today = LocalDate.now();
		LocalDate date = today.plusDays(i);
		return date;
	}
	
//	-----
	public Integer selectOneCountRsrvList(Integer seq) {
		ReservationVo vo = new ReservationVo();
		vo.setSeq(seq.toString());
		Integer countRsrv = dao.selectOneCountRsrvList(vo);
		return countRsrv;
	}
	public Integer selectOneCountInRList(Integer seq) {
		ReservationVo vo = new ReservationVo();
		vo.setSeq(seq.toString());
		Integer countInR = dao.selectOneCountInRList(vo);
		return countInR;
	}
}
