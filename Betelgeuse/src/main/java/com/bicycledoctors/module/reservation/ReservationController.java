package com.bicycledoctors.module.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bicycledoctors.module.shop.ShopAvailableServiceDto;
import com.bicycledoctors.module.shop.ShopAvailableServicesDto;

@Controller
public class ReservationController {

	@Autowired
	ReservationService service;
	
	@RequestMapping(value = "/shop/shopResrvInst")
	public String shopResrvInst(Model model, ReservationDto dto, ShopAvailableServicesDto listAS) {
		List<ShopAvailableServiceDto> dtoList = new ArrayList<>();
		service.insert(dto);
		if (listAS.getAvailableServiceCd() != null && !listAS.getAvailableServiceCd().isEmpty()) {
			for (Integer code : listAS.getAvailableServiceCd()) {
				ShopAvailableServiceDto availableServiceDto = new ShopAvailableServiceDto();
				availableServiceDto.setShopSeq(listAS.getShopSeq());
				availableServiceDto.setAvailableServiceCd(code);
				availableServiceDto.setRsrvSeq(dto.getRsrvSeq());
				dtoList.add(availableServiceDto);
			}
		}
		service.rsrvServicesInst(dtoList);
		return "redirect:/member/userBicycleUsrList";
	}

	@RequestMapping(value = "/shop/resrvUsrViewProc")
	public String resrvUsrViewProc(Model model, ReservationVo vo) {
		model.addAttribute("view", service.selectOne4View(vo));
		model.addAttribute("serviceList", service.selectList4ServiceView(vo));
		return "usr/member/ServiceAdministration :: modalContent";
	}
	@RequestMapping(value = "/shop/InRUsrform")
	public String inRUsrform(Model model, ReservationVo vo) {
		model.addAttribute("item", service.selectOne4View(vo));
		return "usr/shop/InRUsrform";
	}

	@ResponseBody
	@RequestMapping(value = "/shop/resrvUsrProc")
	public void resrvUsrProc(ReservationDto dto) {
		if (dto.getBikeStatus() == 122) {
			service.rsrvYesUpdt(dto);
		} else {
			service.rsrvNoUpdt(dto);
		}
	}
}
